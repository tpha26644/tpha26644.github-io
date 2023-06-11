/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
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
public class CategoryDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public Category getOne(Category c) {
        try {
            String sql = "select * from Category where categoryID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getCategoryID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Category ca = new Category(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                return ca;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Category> list = new ArrayList<>();
        list = new CategoryDAO().getAll();
        for (Category category : list) {
            System.out.println(category);
        }
    }

    public ArrayList<Category> getAll() {
        ArrayList<Category> list = new ArrayList<>();
        try {
            String sql = "select * from Category";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category ca = new Category(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                list.add(ca);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int totalCategory() {
        String sql = "SELECT COUNT(*) FROM Category";
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
}
