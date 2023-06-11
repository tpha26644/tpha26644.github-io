/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.SymptomOfLearner;
import entity.Account;
import entity.HealthStatus;
import entity.Symptom;
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
public class HealthStatusDAO extends DBContext {

  private PreparedStatement ps;
  private ResultSet rs;

  public int insertHealthStatus(HealthStatus healthStatus) {
    int n = 0;
    String sql = "insert into Health_Status values(?,?,1)";

    try {
      ps = connection.prepareStatement(sql);
      ps.setInt(1, healthStatus.getLearnerId());
      ps.setInt(2, healthStatus.getSymptomId());
      n = ps.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(HealthStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return n;
  }
  
  public int changeStatusHealthStatus(int learnerId, int symptomId, int status) {
    int n = 0;
    String sql = "UPDATE Health_Status SET status=? WHERE leanerID=? AND symptomID=?";

    try {
      ps = connection.prepareStatement(sql);
      ps.setInt(1, status);
      ps.setInt(2, learnerId);
      ps.setInt(3, symptomId);
      n = ps.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(HealthStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return n;
  }

  public ArrayList<HealthStatus> getListHealthStatusByAccount(Account account) {
    ArrayList<HealthStatus> list = new ArrayList<>();
    try {
      String sql = "select distinct Health_Status.* from Account inner join Learner\n"
              + "on Account.accountID = Learner.learnerID\n"
              + "inner join Health_Status\n"
              + "on Learner.learnerID = Health_Status.leanerID\n"
              + "where accountID = 7";

      ps = connection.prepareStatement(sql);
      ps.setInt(1, account.getAccountID());
      rs = ps.executeQuery();
      while (rs.next()) {
        HealthStatus hs = new HealthStatus(rs.getInt(1), rs.getInt(2), rs.getInt(3));
        list.add(hs);
      }
      return list;
    } catch (SQLException ex) {
      Logger.getLogger(HealthStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public ArrayList<SymptomOfLearner> getListSymptomByAccount(Account account) {
    ArrayList<SymptomOfLearner> list = new ArrayList<>();
    try {
      String sql = "select distinct Symptom.*, Health_Status.leanerID, Health_Status.status "
              + "from Account inner join Learner\n"
              + "on Account.accountID = Learner.accountID\n"
              + "inner join Health_Status\n"
              + "on Learner.learnerID = Health_Status.leanerID and Account.accountID = ?\n"
              + "right join Symptom\n"
              + "on Health_Status.symptomID = Symptom.symptomID\n";

      ps = connection.prepareStatement(sql);
      ps.setInt(1, account.getAccountID());
      rs = ps.executeQuery();
      while (rs.next()) {
        SymptomOfLearner symptomOfLearner = new SymptomOfLearner(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getInt(5),
                rs.getInt(6));
        list.add(symptomOfLearner);
      }
      return list;
    } catch (SQLException ex) {
      Logger.getLogger(HealthStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public static void main(String[] args) {
    HealthStatusDAO hsDAO = new HealthStatusDAO();
    ArrayList<SymptomOfLearner> list;
    Account acc=new Account(7, "", "", true, 3);
    list= hsDAO.getListSymptomByAccount(acc);
    for (SymptomOfLearner item : list) {
      System.out.println(item);
    }
  }
}
