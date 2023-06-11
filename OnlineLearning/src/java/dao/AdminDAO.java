/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Linh
 */
public class AdminDAO extends DBContext {

  PreparedStatement ps;
  ResultSet rs;

  public Admin getAdminbyEmail(String email) {
    Admin admin = null;
    String sql = "SELECT * FROM Admin WHERE email=?";
    try {
      ps = connection.prepareStatement(sql);
      ps.setString(1, email);
      rs = ps.executeQuery();
      while (rs.next()) {
        admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return admin;

  }

  public Admin getAdminByAccount(Account account) {
    try {
      String sql = "select * from Admin where accountID = ?";
      ps = connection.prepareStatement(sql);
      ps.setInt(1, account.getAccountID());
      rs = ps.executeQuery();
      while (rs.next()) {
        Admin l = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
                rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));

        return l;
      }
    } catch (SQLException ex) {
      Logger.getLogger(LearnerDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public int updade(Admin admin) {
    int n = 0;
    String sql = "UPDATE [dbo].[admin]\n"
            + "   SET [fullname] = ?\n"
            + "      ,[gender] = ?\n"
            + "      ,[dob] = ?\n"
            + "      ,[address] = ?\n"
            + "      ,[email] = ?\n"
            + "      ,[phone] = ?\n"
            + " WHERE adminID=?";
    try {
      ps = connection.prepareStatement(sql);
      ps.setString(1, admin.getFullname());
      ps.setBoolean(2, admin.isGender());
      ps.setDate(3, admin.getDob());
      ps.setString(4, admin.getAddress());
      ps.setString(5, admin.getEmail());
      ps.setString(6, admin.getPhone());
      ps.setInt(7, admin.getAdminID());
      n = ps.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return n;
  }

  public void updadePassword(Account acc, String username) {
//        String sql = "UPDATE [dbo].[account]\n"
//                + "   SET [password] = ?\n"
//                + "      ,[displayName] = ?\n"
//                + "      ,[address] = ?\n"
//                + "      ,[email] = ?\n"
//                + "      ,[phone] = ?\n"
//                + "      ,[role_id] = ?\n"
//                + "      ,[status] = ?\n"
//                + " WHERE username=?";
//        try {
//            Connection con = new DBContext().getConnection();
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, acc.getPassword());
//            ps.setString(2, acc.getDisplayName());
//            ps.setString(3, acc.getAddress());
//            ps.setString(4, acc.getEmail());
//            ps.setString(5, acc.getPhone());
//            ps.setInt(6, acc.getRoleId());
//            ps.setInt(7, acc.getStatus());
//            ps.setString(8, username);
//            ps.executeUpdate();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
  }
}
