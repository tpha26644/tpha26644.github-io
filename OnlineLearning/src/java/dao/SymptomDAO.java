/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Learner;
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
public class SymptomDAO extends DBContext {

  private PreparedStatement ps;
  private ResultSet rs;

  public int insertSymptom(Symptom symp) {
    int n = 0;
    String sql = "insert into Symptom values(?,?,?,1)";

    try {
      ps = connection.prepareStatement(sql);
      ps.setInt(1, symp.symptomId);
      ps.setString(2, symp.symptomName);
      ps.setInt(3, symp.categoryId);
      n = ps.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(SymptomDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return n;
  }

  public ArrayList<Symptom> getListSymptom() {
    ArrayList<Symptom> arr = new ArrayList<>();
    String sql = "select * from Symptom";
    rs = getData(sql);
    try {
      while (rs.next()) {
        int symptomId = rs.getInt(1);
        String symptomName = rs.getString(2);
        int categoryId = rs.getInt(3);
        int status = rs.getInt(4);
        Symptom symp = new Symptom(symptomId, symptomName, categoryId, status);
        arr.add(symp);
      }
      return arr;
    } catch (SQLException ex) {
      Logger.getLogger(SymptomDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public ArrayList<Symptom> getListSymptomByLearner(Learner learner) {
    ArrayList<Symptom> list = new ArrayList<>();

    try {
      String sql = "select distinct Symptom.* from Account inner join Learner\n"
              + "on Account.accountID = Learner.accountID\n"
              + "inner join Health_Status\n"
              + "on Learner.learnerID = Health_Status.leanerID\n"
              + "inner join Symptom on Health_Status.symptomID = Symptom.symptomID\n"
              + "where Learner.learnerID = ? and Health_Status.status = 1";

      ps = connection.prepareStatement(sql);
      ps.setInt(1, learner.getLearnerID());
      rs = ps.executeQuery();
      while (rs.next()) {
        Symptom s = new Symptom(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
        list.add(s);
      }
      return list;
    } catch (SQLException ex) {
      Logger.getLogger(SymptomDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
