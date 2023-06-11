/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Category;
import entity.Course;
import entity.Lecture;
import java.sql.Date;
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
public class LectureDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public Lecture getLecturebyEmail(String email) {
        Lecture lecture = null;
        String sql = "SELECT * FROM Lecture WHERE email=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                lecture = new Lecture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecture;

    }

    public Lecture getLectureByAccount(Account account) {
        try {
            String sql = "select * from Lecture where accountID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, account.getAccountID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture lec = new Lecture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4),
                        rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));

                return lec;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LearnerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Lecture getOne(Lecture lecture) {
        String sql = "SELECT * FROM Lecture WHERE lectureID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, lecture.getLectureID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture l = new Lecture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getInt(9));
                return l;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int totalLecturer() {
        String sql = "SELECT COUNT(*) FROM Lecture";
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

    public int updateLecture(Lecture lecture) {
        int n = 0;
        try {
            String sql = "    UPDATE [dbo].[Lecture]\n"
                    + "   SET [fullname] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[address] = ?\n"
                    + "      ,[email] = ?\n"
                    + "      ,[phone] = ? \n"
                    + " WHERE lectureID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, lecture.getFullname());
            ps.setBoolean(2, lecture.isGender());
            ps.setDate(3, lecture.getDob());
            ps.setString(4, lecture.getAddress());
            ps.setString(5, lecture.getEmail());
            ps.setString(6, lecture.getPhone());
            ps.setInt(7, lecture.getLectureID());
            n = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        LectureDAO d = new LectureDAO();
        String datestr = "2000-10-18";
        Date dob = Date.valueOf(datestr);

        Lecture lecture = new Lecture(15, "Nguyen Van A", true, dob, "Dao Tu", "daotu@gmail.com", "0353178492");
        int i = d.updateLecture(lecture);
        System.out.println(i);
    }

    public ArrayList<Lecture> getAllLecture() {
        ArrayList<Lecture> list = new ArrayList<>();
        try {
            String sql = "select * from Lecture";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture l = new Lecture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getDate(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getInt(9));
                list.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Lecture> getAllPaging(int pageIndex, int pageSize) {
        ArrayList<Lecture> list = new ArrayList<>();
        try {
            String sql = "select * from Lecture order by lectureID\n"
                    + "offset (?-1)*? row fetch next ? row only";
            ps = connection.prepareCall(sql);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture l = new Lecture(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getBoolean(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));

                list.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int addLectureByAdmin(Lecture lecture) {
        int status = 0;
        String sql = "Insert into Lecture (fullname, email , phone, accountID)"
                + "values (?, ?, ?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, lecture.getFullname());
            ps.setString(2, lecture.getEmail());
            ps.setString(3, lecture.getPhone());
            ps.setInt(4, lecture.getAccountID());

            status = ps.executeUpdate();

        } catch (Exception e) {
        }

        return status;
    }

    public int addLecture(Lecture lecture) {
        int status = 0;
        String sql = "Insert into Lecture (fullname, address , email , phone, accountID)"
                + "values (?, ?, ?, ?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, lecture.getFullname());
            ps.setString(2, lecture.getAddress());
            ps.setString(3, lecture.getEmail());
            ps.setString(3, lecture.getPhone());
            ps.setInt(5, lecture.getAccountID());

            status = ps.executeUpdate();

        } catch (Exception e) {
        }

        return status;
    }

    public void update(Lecture lecture) {
        try {
            String sql = "UPDATE [dbo].[Lecture]\n"
                    + "   SET [fullname] = ?\n"
                    + "      ,[image] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[address] = ?\n"
                    + "      ,[email] = ?\n"
                    + "      ,[phone] = ?\n"
                    + " WHERE lectureID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, lecture.getFullname());
            ps.setString(2, lecture.getImage());
            ps.setBoolean(3, lecture.isGender());
            ps.setDate(4, lecture.getDob());
            ps.setString(5, lecture.getAddress());
            ps.setString(6, lecture.getEmail());
            ps.setString(7, lecture.getPhone());
            ps.setInt(8, lecture.getLectureID());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
