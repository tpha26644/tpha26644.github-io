/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LectureAndAccount;
import entity.Lecture;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class LectureAndAccountDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<LectureAndAccount> getAll() {
        ArrayList<LectureAndAccount> list = new ArrayList<>();
        try {
            String sql = "select * from Lecture l join Account a on l.accountID = a.accountID";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture l = new Lecture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getInt(9));
                LectureAndAccount la = new LectureAndAccount(l, rs.getBoolean(13), rs.getString(11));
                list.add(la);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStatus(int lectuerID, boolean status) {
        try {
            String sql = "update Account set status = ? "
                    + "where accountID = (select Account.accountID "
                    + "from Account join Lecture on Account.accountID = Lecture.accountID "
                    + "where lectureID = ?)";
            ps = connection.prepareStatement(sql);
            ps.setBoolean(1, status);
            ps.setInt(2, lectuerID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LectureAndAccount getLectureById(String id) {
        LectureAndAccount lecture = null;
        try {
            String sql = "select * from Lecture l join Account a on l.accountID = a.accountID"
                    + " where lectureID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture l = new Lecture(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7), 
                        rs.getString(8), rs.getInt(9));
                lecture = new LectureAndAccount(l, rs.getBoolean(13), rs.getString(11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lecture;
    }

    public static void main(String[] args) {
        LectureAndAccountDAO dao = new LectureAndAccountDAO();
    }
}
