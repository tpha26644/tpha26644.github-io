/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author haili
 */
public class Chapter {

    private int chapterID;
    private String chapterName;
    private Course course;
    private boolean status;

    public Chapter() {
    }

    public Chapter(int chapterID, String chapterName, Course course, boolean status) {
        this.chapterID = chapterID;
        this.chapterName = chapterName;
        this.course = course;
        this.status = status;
    }

    public Chapter(String chapterName, Course course, boolean status) {
        this.chapterName = chapterName;
        this.course = course;
        this.status = status;
    }

    public int getChapterID() {
        return chapterID;
    }

    public void setChapterID(int chapterID) {
        this.chapterID = chapterID;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Chapter{" + "chapterID=" + chapterID + ", chapterName=" + chapterName + ", course=" + course + ", status=" + status + '}';
    }

}
