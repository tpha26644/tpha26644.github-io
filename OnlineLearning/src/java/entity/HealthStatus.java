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
public class HealthStatus {

    private int learnerId;
    public int symptomId, status;

    public HealthStatus() {
    }

    public HealthStatus(int learnerId, int symptomId, int status) {
        this.learnerId = learnerId;
        this.symptomId = symptomId;
        this.status = status;
    }

    public int getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(int learnerId) {
        this.learnerId = learnerId;
    }

    public int getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(int symptomId) {
        this.symptomId = symptomId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HealthStatus{" + "learnerId=" + learnerId + ", symptomId=" + symptomId + ", status=" + status + '}';
    }
}
