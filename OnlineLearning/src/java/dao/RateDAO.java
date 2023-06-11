/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Rate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author asus
 */
public class RateDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public int addRate(Rate r) {
        int n = 0;
        try {
            String sql = "INSERT INTO [dbo].[Rate]\n"
                    + "           ([learnerID]\n"
                    + "           ,[lessonID]\n"
                    + "           ,[rate]\n"
                    + "           ,[timeRate]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, r.getLearnerID());
            ps.setInt(2, r.getLessonID());
            ps.setInt(3, r.getRate());
            ps.setDate(4, r.getTimeRate());
            ps.setBoolean(5, r.isStatus());
            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public int getRateByLearnerAndLesson(int learnerId, int lessonId) {
        int rate = 0;
        try {
            String sql = "select * from Rate where learnerID = ? and lessonID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, learnerId);
            ps.setInt(2, lessonId);
            rs = ps.executeQuery();
            while (rs.next()) {
                rate = rs.getInt(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rate;
    }

    public int updateRate(int rate, int learnerId, int lessonId) {
        int n = 0;
        try {
            String sql = "update Rate set rate = ? where learnerID = ? and lessonID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, rate);
            ps.setInt(2, learnerId);
            ps.setInt(3, lessonId);
            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        RateDAO dao = new RateDAO();

        java.util.Date utilDate = new java.util.Date();
        Date date = new Date(utilDate.getTime());
        Rate r = new Rate(6, 5, 4, date, true);
//        dao.addRate(r);
        dao.updateRate(1, 6, 5);

    }

}
