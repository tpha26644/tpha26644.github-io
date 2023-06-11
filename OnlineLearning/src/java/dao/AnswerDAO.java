/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Answer;
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
public class AnswerDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Answer> getAnswerByQuizID(int quizID) {
        try {
            ArrayList<Answer> list = new ArrayList<>();
            String sql = "select Answer.* from Answer inner join Question \n"
                    + "on Answer.questionID = Question.questionID\n"
                    + "where quizID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, quizID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question = new QuestionDAO().getOne(rs.getInt(2));

                Answer a = new Answer(rs.getInt(1), question, rs.getInt(3), rs.getBoolean(4), rs.getString(5));
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int countAnswerByQuestionID(int questionID) {
        int count = 0;
        try {
            String sql = "  select count(*) from Question inner join Answer\n"
                    + "  on Question.questionID = Answer.questionID\n"
                    + "  where Question.questionID = ? and Answer.status = 1";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, questionID);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public void insert(ArrayList<Answer> list_answer) {
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [dbo].[Answer]\n"
                    + "           ([questionID]\n"
                    + "           ,[answer]\n"
                    + "           ,[status]\n"
                    + "           ,[answer_content])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?)";
            for (Answer a : list_answer) {
                ps = connection.prepareStatement(sql);
                ps.setInt(1, a.getQuestion().getQuestionID());
                ps.setInt(2, a.getAnswer());
                ps.setBoolean(3, a.isStatus());
                ps.setString(4, a.getAnswer_content());
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

    public ArrayList<Answer> getAnswerByQuestionID(int questionID) {
        try {
            ArrayList<Answer> list = new ArrayList<>();
            String sql = "select * from Answer where questionID = ?";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, questionID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question = new QuestionDAO().getOne(rs.getInt(2));

                Answer a = new Answer(rs.getInt(1), question, rs.getInt(3), rs.getBoolean(4), rs.getString(5));
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Answer a) {
        try {
            String sql = "UPDATE [dbo].[Answer]\n"
                    + "   SET [answer_content] = ?\n"
                    + " WHERE answerID = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, a.getAnswer_content());
            ps.setInt(2, a.getAnswerID());
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
