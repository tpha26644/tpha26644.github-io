/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Question;
import entity.Quiz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duc Anh
 */
public class QuestionDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Question> getQuestionByQuizID(int quizID) {
        try {
            ArrayList<Question> list = new ArrayList<>();
            String sql = "select * from Question where quizID = ? and Question.status = 1";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, quizID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz = new QuizDAO().getOne(rs.getInt(4));

                Question question = new Question(rs.getInt(1), rs.getString(2), rs.getInt(3), quiz, rs.getBoolean(5));
                list.add(question);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Question getOne(int aInt) {
        try {
            String sql = "select * from Question where questionID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, aInt);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz = new QuizDAO().getOne(rs.getInt(4));

                Question question = new Question(rs.getInt(1), rs.getString(2), rs.getInt(3), quiz, rs.getBoolean(5));
                return question;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(ArrayList<Question> list_question) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [dbo].[Question]\n"
                    + "           ([content]\n"
                    + "           ,[correctAnswer]\n"
                    + "           ,[quizID]\n"
                    + "           ,[status])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?)";
            for (Question q : list_question) {
                ps = connection.prepareStatement(sql);
                ps.setString(1, q.getContent());
                ps.setInt(2, q.getCorrectAnswer());
                ps.setInt(3, q.getQuiz().getQuizID());
                ps.setBoolean(4, q.isStatus());
                ps.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (Exception e) {
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void update(Question q) {
        try {
            String sql = "UPDATE [dbo].[Question]\n"
                    + "   SET [content] = ? ,[correctAnswer] = ?\n"
                    + " WHERE questionID = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, q.getContent());
            ps.setInt(2, q.getCorrectAnswer());
            ps.setInt(3, q.getQuestionID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int questionID) {
        try {
            String sql = "UPDATE [dbo].[Question]\n"
                    + "   SET [status] = 0\n"
                    + " WHERE questionID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, questionID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int countQuestionByQuizID(int quizID) {
        int count = 0;
        try {
            String sql = "  select count(*) from Quiz inner join Question\n"
                    + "  on Quiz.quizID = Question.quizID\n"
                    + "  where Quiz.quizID = ? and Question.status = 1";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, quizID);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

}
