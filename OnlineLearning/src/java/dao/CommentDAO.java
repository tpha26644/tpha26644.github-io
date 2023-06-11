/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LearnerAndComment;
import entity.Comment;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author asus
 */
public class CommentDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public int addComment(Comment c) {
        int n = 0;
        try {
            String sql = "INSERT INTO [dbo].[Comment]\n"
                    + "           ([learnerID]\n"
                    + "           ,[lessonID]\n"
                    + "           ,[content]\n"
                    + "           ,[timeComment]\n"
                    + "           ,[status])\n"
                    + "     VALUES(?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getLearnerID());
            ps.setInt(2, c.getLessonID());
            ps.setString(3, c.getContent());
            ps.setDate(4, c.getTimeComment());
            ps.setBoolean(5, c.isStatus());
            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public int getToTalPage(int lessonID) {
        int totalPage = 0;
        try {
            String sql = "select count(*) from Comment where lessonID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, lessonID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                totalPage = total / 3;
                if (total % 3 != 0) {
                    totalPage++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalPage;
    }

    public ArrayList<LearnerAndComment> pagingCmt(int lessonID, int index) {
        ArrayList<LearnerAndComment> listCmt = new ArrayList<>();
        try {
            String sql = "select * from Comment c join Learner l on c.learnerID = l.learnerID \n"
                    + "where c.lessonID = ? order by c.commentID desc\n"
                    + "offset ? rows fetch next 3 rows only";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, lessonID);
            ps.setInt(2, (index*3-3));
            rs = ps.executeQuery();
            while (rs.next()) {
                Comment c = new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5), rs.getBoolean(6));
                LearnerAndComment lac = new LearnerAndComment(c, rs.getString(8));
                listCmt.add(lac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCmt;
    }

    public ArrayList<LearnerAndComment> getCommentByLesson(int lessonID) {
        ArrayList<LearnerAndComment> listCmt = new ArrayList<>();
        try {
            String sql = "  select * from Comment c join Learner l on c.learnerID = l.learnerID"
                    + " where c.lessonID = ? order by timeComment desc";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, lessonID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comment c = new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5), rs.getBoolean(6));
                LearnerAndComment lac = new LearnerAndComment(c, rs.getString(8));
                listCmt.add(lac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCmt;
    }

    public static void main(String[] args) {
        CommentDAO dao = new CommentDAO();
        //insert test
        java.util.Date utilDate = new java.util.Date();
        Date date = new Date(utilDate.getTime());
        Comment c = new Comment(3, 5, "bai hoc rat huu ich", date, true);
        int n = dao.addComment(c);
        System.out.println(n);
        //get list cmt by lesson
//        ArrayList<LearnerAndComment> listC = dao.getCommentByLesson(30);
//        for (LearnerAndComment comment : listC) {
//            System.out.println(comment);
//        }
    }
}
