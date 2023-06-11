/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Course;
import entity.Learner;
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
public class CourseDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public Course getOne(Course course) {
        try {
            String sql = "Select * from Course where courseID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, course.getCourseID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setLectureID(rs.getInt(7));
                lecture = new LectureDAO().getOne(lecture);

                Category ca = new Category();
                ca.setCategoryID(rs.getInt(8));
                ca = new CategoryDAO().getOne(ca);

                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), lecture, ca, rs.getBoolean(9));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Course> getAllCourse() {
        ArrayList<Course> listC = new ArrayList<>();
        try {
            String sql = "Select * from Course";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setLectureID(rs.getInt(7));
                lecture = new LectureDAO().getOne(lecture);

                Category ca = new Category();
                ca.setCategoryID(rs.getInt(8));
                ca = new CategoryDAO().getOne(ca);

                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), lecture, ca, rs.getBoolean(9));

                listC.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listC;
    }

    public ArrayList<Course> getAllPaging(int pageIndex, int pageSize) {
        ArrayList<Course> list = new ArrayList<>();
        try {
            String sql = "select * from Course order by courseID\n"
                    + "offset (?-1)*? row fetch next ? row only";
            ps = connection.prepareCall(sql);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setLectureID(rs.getInt(7));
                lecture = new LectureDAO().getOne(lecture);

                Category ca = new Category();
                ca.setCategoryID(rs.getInt(8));
                ca = new CategoryDAO().getOne(ca);

                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), lecture, ca, rs.getBoolean(9));

                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Course> getAllPaging1(int cateID, int pageIndex, int pageSize) {
        ArrayList<Course> list = new ArrayList<>();
        try {
            String sql = "select * from Course where categoryID=? order by courseID\n"
                    + "offset (?-1)*? row fetch next ? row only";
            ps = connection.prepareCall(sql);
            ps.setInt(1, cateID);
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageSize);
            ps.setInt(4, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setLectureID(rs.getInt(7));
                lecture = new LectureDAO().getOne(lecture);

                Category ca = new Category();
                ca.setCategoryID(rs.getInt(8));
                ca = new CategoryDAO().getOne(ca);

                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), lecture, ca, rs.getBoolean(9));

                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Course> getTop5Course() {
        ArrayList<Course> listC = new ArrayList<>();
        try {
            String sql = "select top 5 * from Course ORDER BY courseID desc";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(9));

                listC.add(c);
            }
        } catch (Exception e) {
        }
        return listC;
    }

    public ArrayList<Course> getTop4Course() {
        ArrayList<Course> listC = new ArrayList<>();
        try {
            String sql = "select top 4 * from Course ORDER BY courseID desc";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(9));

                listC.add(c);
            }
        } catch (Exception e) {
        }
        return listC;
    }

    public int totalCourse() {
        String sql = "SELECT COUNT(*) FROM Course";
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

    public void insert(Course course) {
        try {
            String sql = "INSERT INTO [dbo].[Course]\n"
                    + "           ([image]\n"
                    + "           ,[courseName]\n"
                    + "           ,[overview]\n"
                    + "           ,[description]\n"
                    + "           ,[createDate]\n"
                    + "           ,[authorID]\n"
                    + "           ,[categoryID]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, course.getImage());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getOverview());
            ps.setString(4, course.getDescription());
            ps.setDate(5, course.getCreateDate());
            ps.setInt(6, course.getAuthor().getLectureID());
            ps.setInt(7, course.getCategory().getCategoryID());
            ps.setBoolean(8, course.isStatus());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    public void update(Course course) {
        try {
            String sql = "UPDATE [dbo].[Course]\n"
                    + "   SET [image] = ?\n"
                    + "      ,[courseName] = ?\n"
                    + "      ,[overview] = ?\n"
                    + "      ,[description] = ?\n"
                    + "      ,[categoryID] = ?\n"
                    + " WHERE [courseID] = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, course.getImage());
            ps.setString(2, course.getCourseName());
            ps.setString(3, course.getOverview());
            ps.setString(4, course.getDescription());
            ps.setInt(5, course.getCategory().getCategoryID());
            ps.setInt(6, course.getCourseID());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public ArrayList<Course> getCourseBySymptomOfLearner(Learner l) {
        ArrayList<Course> listC = new ArrayList<>();
        try {
            String sql = "select distinct Course.* \n"
                    + "from Learner join Health_Status on Learner.learnerID = Health_Status.leanerID\n"
                    + "join Symptom on Health_Status.symptomID=Symptom.symptomID\n"
                    + "join Category on Symptom.categoryID=Category.categoryID\n"
                    + "join Course on Category.categoryID = Course.categoryID\n"
                    + "where leanerID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, l.getLearnerID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(9));

                listC.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listC;
    }

    public ArrayList<Course> getCourseByAuthor(Lecture l) {
        ArrayList<Course> listC = new ArrayList<>();
        try {
            String sql = "Select * from Course where authorID = ? and status = 1";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, l.getLectureID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setLectureID(rs.getInt(7));
                lecture = new LectureDAO().getOne(lecture);

                Category ca = new Category();
                ca.setCategoryID(rs.getInt(8));
                ca = new CategoryDAO().getOne(ca);

                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), lecture, ca, rs.getBoolean(9));

                listC.add(c);
            }
        } catch (Exception e) {
        }
        return listC;
    }
    
    public ArrayList<Course> getCourseByCate(int cateID) {
        ArrayList<Course> listC = new ArrayList<>();
        try {
            String sql = "Select * from Course where categoryID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, cateID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setLectureID(rs.getInt(7));
                lecture = new LectureDAO().getOne(lecture);

                Category ca = new Category();
                ca.setCategoryID(cateID);
                ca = new CategoryDAO().getOne(ca);

                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), lecture, ca, rs.getBoolean(9));

                listC.add(c);
            }
        } catch (Exception e) {
        }
        return listC;
    }

    public Course getOneByCourseID(int courseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTotalCourseByAuthor(Lecture lecture) {
        int total = 0;
        try {
            String sql = "select * from Course where authorID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, lecture.getLectureID());
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return total;
    }

    public static void main(String[] args) {
        String sql = "Select * from Course where authorID = 1 and 1 = 1 ";
        String txt_search = "", raw_date = "2022-02-21", raw_category = "1";
        if (!txt_search.equals("")) {
            sql += "and courseName like N'%?%' ";
        }
        if (!raw_date.equals("")) {
            sql += "and createDate = '?' ";
        }
        if (!raw_category.equals("")) {
            sql += "and categoryID = ? ";
        }
        sql += "and status = 1";
        System.out.println(sql);
    }

    public ArrayList<Course> searchCourse(Lecture l, String txt_search, String raw_date, int category_id) {
        ArrayList<Course> listC = new ArrayList<>();
        try {
            String sql = "Select * from Course where authorID = ? and status = 1 ";
            if (!txt_search.equals("")) {
                sql += "and courseName like N'%" + txt_search + "%' ";
            }
            if (!raw_date.equals("")) {
                sql += "and createDate = '" + Date.valueOf(raw_date) + "' ";
            }
            if (category_id != -1) {
                sql += "and categoryID = " + category_id;
            }
            ps = connection.prepareStatement(sql);
            ps.setInt(1, l.getLectureID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setLectureID(rs.getInt(7));
                lecture = new LectureDAO().getOne(lecture);

                Category ca = new Category();
                ca.setCategoryID(rs.getInt(8));
                ca = new CategoryDAO().getOne(ca);

                Course c = new Course(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), lecture, ca, rs.getBoolean(9));

                listC.add(c);
            }
        } catch (Exception e) {
        }
        return listC;
    }

    public void delete(int courseID) {
        try {
            String sql = "UPDATE [dbo].[Course]\n"
                    + "   SET [status] = 0\n"
                    + " WHERE courseID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, courseID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
