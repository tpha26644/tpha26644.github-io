/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.LearnerAndAccount;
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
public class LearnerAndAccountDAO extends DBContext {

  private PreparedStatement ps;
  private ResultSet rs;

  public ArrayList<LearnerAndAccount> getAll() {
    ArrayList<LearnerAndAccount> list = new ArrayList<>();

    String sql = "select * from Learner join Account on Learner.AccountID=Account.AccountID";
    try {
      ps = connection.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {

        LearnerAndAccount a = new LearnerAndAccount(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getBoolean(4),
                rs.getDate(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getInt(9),
                rs.getString(11),
                rs.getString(12),
                rs.getBoolean(13),
                rs.getInt(14));
        list.add(a);

      }
      return list;
    } catch (SQLException ex) {
      Logger.getLogger(LearnerAndAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public void changeStatus(int learnerID, boolean status) {
    String sql = "UPDATE Account SET status=?\n"
            + " WHERE accountID = \n"
            + "	(SELECT Account.accountID \n"
            + "	FROM Account JOIN Learner "
            + " ON Account.accountID=Learner.accountID\n"
            + "	WHERE Learner.learnerID = ?)";
    try {
      ps = connection.prepareStatement(sql);
      ps.setBoolean(1, status);
      ps.setInt(2, learnerID);
      ps.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(LearnerAndAccountDAO.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

}
