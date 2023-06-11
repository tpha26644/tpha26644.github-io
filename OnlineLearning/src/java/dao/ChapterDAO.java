/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Chapter;
import entity.Course;
import entity.Lecture;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haili
 */
public class ChapterDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public int getTotalChapterByCourse(Course c) {
        int total = 0;
        try {
            String sql = "select count(*)\n"
                    + "from Course inner join Chapter on Course.courseID = Chapter.courseID\n"
                    + "where Chapter.courseID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getCourseID());
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public ArrayList<Chapter> getListChapterByCourse(Course c) {
        ArrayList<Chapter> list = new ArrayList<>();
        try {
            String sql = "select * from Chapter\n"
                    + "where courseID = ? and Chapter.status = 1";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getCourseID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getInt(3));
                course = new CourseDAO().getOne(course);

                Chapter chapter = new Chapter(rs.getInt(1), rs.getString(2), course, rs.getBoolean(3));
                list.add(chapter);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Chapter> getAllChapters() {
        ArrayList<Chapter> list = new ArrayList<>();
        try {
            String sql = "select * from Chapter";

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getInt(3));
                course = new CourseDAO().getOne(course);

                Chapter chapter = new Chapter(rs.getInt(1), rs.getString(2), course, rs.getBoolean(3));
                list.add(chapter);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Chapter getOne(Chapter chapter) {
        try {
            String sql = "select * from Chapter where chapterID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, chapter.getChapterID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getInt(3));
                course = new CourseDAO().getOne(course);

                Chapter c = new Chapter(rs.getInt(1), rs.getString(2), course, rs.getBoolean(3));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Chapter chapter) {
        try {
            String sql = "INSERT INTO [dbo].[Chapter]\n"
                    + "           ([chapterName]\n"
                    + "           ,[courseID]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?)";

            ps = connection.prepareStatement(sql);
            ps.setString(1, chapter.getChapterName());
            ps.setInt(2, chapter.getCourse().getCourseID());
            ps.setBoolean(3, chapter.isStatus());

            ps.executeLargeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Chapter chapter) {
        try {
            String sql = "UPDATE [dbo].[Chapter]\n"
                    + "   SET [chapterName] = ?, \n"
                    + "       [courseID] = ?\n"
                    + " where chapterID = ?;  ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, chapter.getChapterName());
            ps.setInt(2, chapter.getCourse().getCourseID());
            ps.setInt(3, chapter.getChapterID());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalChapterByAuthor(Lecture lecture) {
        int total = 0;
        try {
            String sql = "select count(*) from Course inner join Chapter \n"
                    + "on Course.courseID = Chapter.courseID and authorID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, lecture.getLectureID());
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public ArrayList<Chapter> search(int l, String txt_search) {
        ArrayList<Chapter> list = new ArrayList<>();
        try {
            String sql = "select * from Chapter\n"
                    + "where courseID = ? and chapterName like N'%" + txt_search + "%'";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, l);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setCourseID(rs.getInt(3));
                course = new CourseDAO().getOne(course);

                Chapter chapter = new Chapter(rs.getInt(1), rs.getString(2), course, rs.getBoolean(3));
                list.add(chapter);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void delete(int chapterID) {
        try {
            String sql = "UPDATE [dbo].[Chapter]\n"
                    + "   SET [status] = 0\n"
                    + " WHERE chapterID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, chapterID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
