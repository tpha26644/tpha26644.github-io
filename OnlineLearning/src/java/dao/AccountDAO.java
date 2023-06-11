/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Role;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Linh
 */
public class AccountDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Account> getAll() {
        ArrayList<Account> list = new ArrayList<>();
        try {
            String sql = "select * from Account";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setRoleID(rs.getInt(5));
                r = new RoleDAO().getOne(r);

                Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5));
                list.add(a);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String toMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
            return myHash;
        } catch (Exception e) {
            return password;
        }
    }

    public int addLecture(Account acc) {
        int n = 0;
        String sql = "insert into Account (username,password,roleID)"
                + "values(?,?,?)";
        System.out.println(sql);
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, acc.getUsername());
            pre.setString(2, toMD5(acc.getPassword()));
            pre.setInt(3, acc.getRoleID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Account getAccount(String userName, String password) {
        Account account = null;
        String sql = "SELECT * FROM Account WHERE username= and password=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, toMD5(password));
            rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return account;

    }

    public int register(Account acc) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[status]\n"
                + "           ,[roleID])\n"
                + "     VALUES (?,?,1,?)";
        System.out.println(sql);
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, acc.getUsername());
            pre.setString(2, toMD5(acc.getPassword()));
            pre.setInt(3, acc.getRoleID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public boolean checkUnique(String username) {
        String sql = "select username from Account";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                if (username.equals(rs.getString("username"))) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void updatePassword(int accountID, String generator) {
        try {
            ps = connection.prepareStatement("update Account\n"
                    + "  set [password] = ?\n"
                    + "  where accountID = ?;");
            ps.setString(1, toMD5(generator));
            ps.setInt(2, accountID);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public Account getOneById(int accountID) {
        Account account = null;
        String sql = "select * from Account where accountID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, accountID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setRoleID(rs.getInt(5));
                r = new RoleDAO().getOne(r);
                account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5));
            }
        } catch (SQLException e) {
        }
        return account;

    }

    public boolean login(String userName, String password) {
        String sql = "select * from Account where username=? and password=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, toMD5(password));
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        System.out.println(dao.checkUnique("qwer"));
    }

}
