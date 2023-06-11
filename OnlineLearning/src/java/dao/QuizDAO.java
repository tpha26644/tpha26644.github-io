/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Course;
import entity.Lecture;
import entity.Lesson;
import entity.Quiz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haili
 */
public class QuizDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public int getTotalQuizBycourse(Course c) {
        int total = 0;
        try {
            String sql = "select count(*)\n"
                    + "from Course inner join Chapter \n"
                    + "on Course.courseID = Chapter.courseID\n"
                    + "inner join Lesson\n"
                    + "on Lesson.chapterID = Chapter.chapterID\n"
                    + "inner join Quiz on Quiz.lessonID = Lesson.lessonID\n"
                    + "where Course.courseID = ?";

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

    public int totalQuiz() {
        String sql = "SELECT COUNT(*) FROM Quiz";
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

    public ArrayList<Quiz> getQuizByLesson(int lessonID) {
        try {
            ArrayList<Quiz> list_quiz = new ArrayList<Quiz>();
            String sql = "select * from Quiz\n"
                    + "where lessonID = ? and Quiz.status = 1";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, lessonID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setLessonID(rs.getInt(2));
                lesson = new LessonDAO().getOne(lesson);

                Quiz quiz = new Quiz(rs.getInt(1), lesson, rs.getBoolean(3));

                list_quiz.add(quiz);
            }
            return list_quiz;
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Quiz getOne(int aInt) {
        try {
            String sql = "select * from Quiz\n"
                    + "where quizID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, aInt);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setLessonID(rs.getInt(2));
                lesson = new LessonDAO().getOne(lesson);

                Quiz quiz = new Quiz(rs.getInt(1), lesson, rs.getBoolean(3));
                return quiz;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Quiz> getListQuizByLesson(Lesson lesson) {
        ArrayList<Quiz> list = new ArrayList<>();
        try {
            String sql = "select * from Quiz\n"
                    + "where lessonID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, lesson.getLessonID());
            rs = ps.executeQuery();
            while (rs.next()) {

                Quiz quiz = new Quiz(rs.getInt(1), lesson, rs.getBoolean(3));
                list.add(quiz);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//  public Quiz getOne(int quizID) {
//    Quiz quiz = null;
//    try {
//      String sql = "select * from Quiz\n"
//              + "where QuizID = ?";
//
//      ps = connection.prepareStatement(sql);
//      ps.setInt(1, quizID);
//      rs = ps.executeQuery();
//      while (rs.next()) {
//        quiz = new Quiz(rs.getInt(1), null, rs.getBoolean(3));
//      }
//    } catch (SQLException ex) {
//      Logger.getLogger(LessonDAO.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    return quiz;
//  }
    public int insert(Quiz quiz) {
        int n = 0;
        try {
            String sql = "INSERT INTO [dbo].[Quiz]\n"
                    + "           ([lessonID]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?, ?) SELECT @@IDENTITY asLastID";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, quiz.getLesson().getLessonID());
            ps.setBoolean(2, quiz.isStatus());
            n = ps.executeUpdate();
            if (n > 0) {
                rs = ps.getGeneratedKeys();
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void insertCorrectAnswer(int correct_answer, int questionID) {
        try {
            String sql = "UPDATE [dbo].[Question]\n"
                    + "   SET [correctAnswer] = ?\n"
                    + "      \n"
                    + " WHERE questionID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, correct_answer);
            ps.setInt(2, questionID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Quiz> getAllQuiz() {
        ArrayList<Quiz> listQuiz = new ArrayList<>();
        try {
            String sql = "select * from Quiz";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setLessonID(rs.getInt(2));
                lesson = new LessonDAO().getOne(lesson);

                Quiz q = new Quiz(rs.getInt(1), lesson, rs.getBoolean(3));
                listQuiz.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listQuiz;
    }

    public void delete(int quizID) {
        try {
            String sql = "UPDATE [dbo].[Quiz]\n"
                    + "   SET [status] = 0\n"
                    + " WHERE quizID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, quizID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
