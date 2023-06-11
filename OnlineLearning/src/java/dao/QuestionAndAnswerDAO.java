/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.QuestionAndAnswer;
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
 * @author NHATNAM-PC
 */
public class QuestionAndAnswerDAO extends DBContext {

  private PreparedStatement ps;
  private ResultSet rs;

  public ArrayList<QuestionAndAnswer> getQuestionByQuizID(int quizID) {
    try {
      ArrayList<QuestionAndAnswer> list = new ArrayList<>();
      String sql = "select * from Question where quizID = ?";

      ps = connection.prepareStatement(sql);
      ps.setInt(1, quizID);
      rs = ps.executeQuery();
      while (rs.next()) {
        Quiz quiz = new Quiz();
        quiz = new QuizDAO().getOne(rs.getInt(4));

        QuestionAndAnswer question = new QuestionAndAnswer(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                quiz,
                rs.getBoolean(5),
                0);
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
}
