/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author NHATNAM-PC
 */
public class SymptomOfLearner {

  public int symptomId, categoryId, status;
  public String symptomName;
  private int learnerId, healthStatus;

  public SymptomOfLearner() {
  }

  public SymptomOfLearner(int symptomId, String symptomName, int categoryId, int status, int learnerId, int healthStatus) {
    this.symptomId = symptomId;
    this.categoryId = categoryId;
    this.status = status;
    this.symptomName = symptomName;
    this.learnerId = learnerId;
    this.healthStatus = healthStatus;
  }

  public int getSymptomId() {
    return symptomId;
  }
  
  public String getStringSymptomId() {
    return String.valueOf(symptomId);
  }

  public void setSymptomId(int symptomId) {
    this.symptomId = symptomId;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getSymptomName() {
    return symptomName;
  }

  public void setSymptomName(String symptomName) {
    this.symptomName = symptomName;
  }

  public int getLearnerId() {
    return learnerId;
  }

  public void setLearnerId(int learnerId) {
    this.learnerId = learnerId;
  }

  public int getHealthStatus() {
    return healthStatus;
  }

  public void setHealthStatus(int healthStatus) {
    this.healthStatus = healthStatus;
  }

  @Override
  public String toString() {
    return "SymptomOfLearner{" + "symptomId=" + symptomId + ", categoryId=" + categoryId + ", status=" + status + ", symptomName=" + symptomName + ", learnerId=" + learnerId + ", healthStatus=" + healthStatus + '}';
  }

}
