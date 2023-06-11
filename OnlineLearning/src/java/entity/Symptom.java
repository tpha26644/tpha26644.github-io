/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author NHATNAM-PC
 */
public class Symptom {

  public int symptomId, categoryId, status;
  public String symptomName;

  public Symptom() {
  }

  public Symptom(int symptomId) {
    this.symptomId = symptomId;
  }

  public Symptom(int symptomId, String symptomName, int categoryId, int status) {
    this.symptomId = symptomId;
    this.categoryId = categoryId;
    this.status = status;
    this.symptomName = symptomName;
  }

  public int getSymptomID() {
    return symptomId;
  }

  public String getStringOfSymptomID() {
    return String.valueOf(symptomId);
  }

  public void setSymptomID(int symptomId) {
    this.symptomId = symptomId;
  }

  public int getCategoryID() {
    return categoryId;
  }

  public void setCategoryID(int categoryId) {
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

  @Override
  public String toString() {
    return "Symptom{" + "symptomId=" + symptomId + ", categoryId=" + categoryId + ", status=" + status + ", symptomName=" + symptomName + '}';
  }

}
