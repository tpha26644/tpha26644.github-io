/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class Rate {
    private int learnerID;
    private int lessonID;
    private int rate;
    private Date timeRate;
    private boolean status;

    public Rate(int learnerID, int lessonID, int rate, Date timeRate, boolean status) {
        this.learnerID = learnerID;
        this.lessonID = lessonID;
        this.rate = rate;
        this.timeRate = timeRate;
        this.status = status;
    }

    public int getLearnerID() {
        return learnerID;
    }

    public void setLearnerID(int learnerID) {
        this.learnerID = learnerID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getTimeRate() {
        return timeRate;
    }

    public void setTimeRate(Date timeRate) {
        this.timeRate = timeRate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rate{" + "learnerID=" + learnerID + ", lessonID=" + lessonID + ", rate=" + rate + ", timeRate=" + timeRate + ", status=" + status + '}';
    }
    
}
