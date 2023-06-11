/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Chapter;
import entity.Course;
import entity.Lecture;
import entity.Lesson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haili
 */
public class LessonDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public int getTotalLessonByCourse(Course c) {
        int total = 0;
        try {
            String sql = "select count(*)\n"
                    + "from Course inner join Chapter on Course.courseID = Chapter.courseID\n"
                    + "inner join Lesson on Chapter.chapterID = Lesson.chapterID\n"
                    + "where Chapter.courseID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getCourseID());
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int totalLesson() {
        String sql = "SELECT COUNT(*) FROM Lesson";
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

    public void insert(Lesson lesson) {
        try {
            String sql = "INSERT INTO [dbo].[Lesson]\n"
                    + "           ([title]\n"
                    + "           ,[reading]\n"
                    + "           ,[video]\n"
                    + "           ,[chapterID]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?)";

            ps = connection.prepareStatement(sql);
            ps.setString(1, lesson.getTitle());
            ps.setString(2, lesson.getReading());
            ps.setString(3, lesson.getVideo());
            ps.setInt(4, lesson.getChapter().getChapterID());
            ps.setBoolean(5, lesson.isStatus());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Lesson> getListLessonByChapter(Chapter ch) {
        ArrayList<Lesson> list = new ArrayList<>();
        try {
            String sql = "select * from Lesson\n"
                    + "where chapterID = ? and Lesson.status = 1";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, ch.getChapterID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Chapter chapter = new Chapter();
                chapter.setChapterID(rs.getInt(5));
                chapter = new ChapterDAO().getOne(chapter);

                Lesson l = new Lesson(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), chapter, rs.getBoolean(6));
                list.add(l);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Lesson> getAllLessons() {
        ArrayList<Lesson> list = new ArrayList<>();
        try {
            String sql = "select * from Lesson";

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Chapter chapter = new Chapter();
                chapter.setChapterID(rs.getInt(5));
                chapter = new ChapterDAO().getOne(chapter);

                Lesson l = new Lesson(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), chapter, rs.getBoolean(6));
                list.add(l);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getTotalLessonByChapter(Chapter ch) {
        int total = 0;
        try {
            String sql = "select count(*)\n"
                    + "from Chapter inner join Lesson on Chapter.chapterID = Lesson.chapterID\n"
                    + "where Chapter.chapterID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, ch.getChapterID());
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public Lesson getOne(Lesson lesson) {
        try {
            String sql = "select * from Lesson where lessonID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, lesson.getLessonID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Chapter ch = new Chapter();
                ch.setChapterID(rs.getInt(5));
                ch = new ChapterDAO().getOne(ch);

                Lesson l = new Lesson(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), ch, rs.getBoolean(6));
                return l;

            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Chapter ch = new Chapter();
        ch.setChapterID(3);
        ArrayList<Lesson> list = new LessonDAO().getListLessonByChapter(ch);
        for (Lesson lesson : list) {
            System.out.println(lesson);
        }
    }

    public int getTotalLessonByAuthor(Lecture lecture) {
        int total = 0;
        try {
            String sql = "select count(*) from Course inner join Chapter \n"
                    + "on Course.courseID = Chapter.courseID and authorID = ?\n"
                    + "inner join Lesson on Chapter.chapterID = Lesson.lessonID";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, lecture.getLectureID());
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public void update(Lesson lesson) {
        try {
            String sql = "UPDATE [dbo].[Lesson]\n"
                    + "   SET [title] = ?\n"
                    + "      ,[reading] = ?\n"
                    + "      ,[video] = ?\n"
                    + "      ,[chapterID] = ?\n"
                    + " WHERE lessonID = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, lesson.getTitle());
            ps.setString(2, lesson.getReading());
            ps.setString(3, lesson.getVideo());
            ps.setInt(4, lesson.getChapter().getChapterID());
            ps.setInt(5, lesson.getLessonID());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Lesson> search(Chapter ch, String txt_search) {
        ArrayList<Lesson> list = new ArrayList<>();
        try {
            String sql = "select * from Lesson\n"
                    + "where chapterID = ? and title like N'%" + txt_search + "%'";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, ch.getChapterID());
            rs = ps.executeQuery();
            while (rs.next()) {
                Chapter chapter = new Chapter();
                chapter.setChapterID(rs.getInt(5));
                chapter = new ChapterDAO().getOne(chapter);

                Lesson l = new Lesson(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), chapter, rs.getBoolean(6));
                list.add(l);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void delete(int lessonID) {
        try {
            String sql = "UPDATE [dbo].[Lesson]\n"
                    + "   SET [status] = 0\n"
                    + " WHERE lessonID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, lessonID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
