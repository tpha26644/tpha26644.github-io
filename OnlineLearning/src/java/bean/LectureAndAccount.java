/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Lecture;

/**
 *
 * @author asus
 */
public class LectureAndAccount {
    
    private Lecture lecture;
    private boolean status;
    private String username;

    public LectureAndAccount() {
    }

    public LectureAndAccount(Lecture lecture, boolean status, String username) {
        this.lecture = lecture;
        this.status = status;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LectureAndAccount{" + "lecture=" + lecture + ", status=" + status + ", username=" + username + '}';
    }
}
