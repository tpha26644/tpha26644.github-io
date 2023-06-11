/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Linh
 */
public class RoleDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public Role getOne(Role r) {
        String sql = "SELECT * FROM Role WHERE roleID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, r.getRoleID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                return role;
            }
        } catch (SQLException e) {
        }
        return null;
    }

}
