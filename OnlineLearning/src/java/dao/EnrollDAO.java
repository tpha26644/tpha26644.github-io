/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Enroll;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EnrollDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public void insert(Enroll enroll) {
        try {
            String sql = "INSERT INTO [dbo].[Enroll]\n"
                    + "           ([learnerID]\n"
                    + "           ,[courseID]\n"
                    + "           ,[timeEnroll]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, enroll.getLearnerID());
            ps.setInt(2, enroll.getCourseID());
            ps.setDate(3, enroll.getTimeEnroll());
            ps.setBoolean(4, enroll.isStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public boolean checkEnroll(int courseID, int learnerID) {
        String sql = "SELECT * from Enroll where courseID=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, courseID);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (learnerID == rs.getInt(2)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnrollDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Enroll> getListEnrollByLearnerID(int learnerID) {
        ArrayList<Enroll> list = new ArrayList<>();
        String sql = "select * from Enroll\n"
                + "where learnerID = ? and status = 1";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, learnerID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Enroll e = new Enroll(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getBoolean(5));
                list.add(e);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EnrollDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
