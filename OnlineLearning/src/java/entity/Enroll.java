/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Enroll {
    private int enrollID;
    private int learnerID;
    private int courseID;
    private Date timeEnroll;
    private boolean status;

    public Enroll() {
    }

    public Enroll(int enrollID, int learnerID, int courseID, Date timeEnroll, boolean status) {
        this.enrollID = enrollID;
        this.learnerID = learnerID;
        this.courseID = courseID;
        this.timeEnroll = timeEnroll;
        this.status = status;
    }

    public int getEnrollID() {
        return enrollID;
    }

    public void setEnrollID(int enrollID) {
        this.enrollID = enrollID;
    }

    public int getLearnerID() {
        return learnerID;
    }

    public void setLearnerID(int learnerID) {
        this.learnerID = learnerID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public Date getTimeEnroll() {
        return timeEnroll;
    }

    public void setTimeEnroll(Date timeEnroll) {
        this.timeEnroll = timeEnroll;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enroll{" + "enrollID=" + enrollID + ", learnerID=" + learnerID + ", courseID=" + courseID + ", timeEnroll=" + timeEnroll + ", status=" + status + '}';
    }
}
