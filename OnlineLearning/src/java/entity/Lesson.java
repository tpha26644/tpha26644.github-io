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
public class Lesson {

    private int lessonID;
    private String title;
    private String reading;
    private String video;
    private Chapter chapter;
    private boolean status;

    public Lesson() {
    }

    public Lesson(int lessonID, String title, String reading, String video, Chapter chapter, boolean status) {
        this.lessonID = lessonID;
        this.title = title;
        this.reading = reading;
        this.video = video;
        this.chapter = chapter;
        this.status = status;
    }

    public Lesson(String title, String reading, String video, Chapter chapter, boolean status) {
        this.title = title;
        this.reading = reading;
        this.video = video;
        this.chapter = chapter;
        this.status = status;
    }

    

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Lesson{" + "lessonID=" + lessonID + ", title=" + title + ", reading=" + reading + ", video=" + video + ", chapter=" + chapter + ", status=" + status + '}';
    }

}
