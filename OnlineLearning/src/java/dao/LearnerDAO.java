/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Admin;
import entity.Learner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Linh
 */
public class LearnerDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public Learner getOneById(int id) {
        Learner learner = null;
        String sql = "SELECT * FROM Learner WHERE learnerID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                learner = new Learner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return learner;
    }

    public int register(Learner lrn) {
        int n = 0;
        String sql = "insert into Learner (fullname,email,phone,accountID)"
                + "values(?,?,?,?)";
        System.out.println(sql);
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, lrn.getFullname());
            pre.setString(2, lrn.getEmail());
            pre.setString(3, lrn.getPhone());
            pre.setInt(4, lrn.getAccountID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LearnerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public ArrayList<Learner> getAllLearner() {
        ArrayList<Learner> listLearner = new ArrayList<>();
        try {
            String sql = "select * from Learner";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Learner l = new Learner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
                        rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));

                listLearner.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LearnerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLearner;
    }

    public Learner getLearnerByAccount(Account account) {
        try {
            String sql = "select * from Learner where accountID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, account.getAccountID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Learner l = new Learner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
                        rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));

                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LearnerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Learner> getLearnerByCourse(int courseID) {
        ArrayList<Learner> listLearner = new ArrayList<>();
        try {
            String sql = "Select * from Learner join Enroll on Learner.learnerID = Enroll.learnerID join Course on Enroll.courseID = Course.courseID where Enroll.courseId=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, courseID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Learner l = new Learner(rs.getString(2), rs.getString(7), rs.getString(8), rs.getInt(9));
                listLearner.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LearnerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLearner;
    }

    public static void main(String[] args) {
        LearnerDAO dao = new LearnerDAO();
        Account a = new Account(7, "", "", true, 3);
        Learner l = dao.getLearnerByAccount(a);
        System.out.println(l);
//    System.out.println(l.getLearnerID());
    }

    public Learner getLearnerbyEmail(String email) {
        Learner learner = null;
        String sql = "SELECT * FROM Learner WHERE email=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                learner = new Learner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return learner;

    }

    public int totalLearner() {
        String sql = "SELECT COUNT(*) FROM Learner";
        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return 0;
    }

    public int updade(Learner learner) {
        int n = 0;
        String sql = "UPDATE [dbo].[learner]\n"
                + "   SET [fullname] = ?\n"
                + "      ,[gender] = ?\n"
                + "      ,[dob] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[phone] = ?\n"
                + " WHERE learnerID=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, learner.getFullname());
            ps.setBoolean(2, learner.isGender());
            ps.setDate(3, learner.getDob());
            ps.setString(4, learner.getAddress());
            ps.setString(5, learner.getEmail());
            ps.setString(6, learner.getPhone());
            ps.setInt(7, learner.getLearnerID());
            n = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public void updadeLearner(Learner learner) {
        String sql = "UPDATE [dbo].[Learner]\n"
                + "   SET [fullname] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[gender] = ?\n"
                + "      ,[dob] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[phone] = ?\n"
                + " WHERE learnerID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, learner.getFullname());
            ps.setString(2, learner.getImage());
            ps.setBoolean(3, learner.isGender());
            ps.setDate(4, learner.getDob());
            ps.setString(5, learner.getAddress());
            ps.setString(6, learner.getEmail());
            ps.setString(7, learner.getPhone());
            ps.setInt(8, learner.getLearnerID());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
