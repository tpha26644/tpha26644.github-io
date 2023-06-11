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
public class Quiz {

    private int quizID;
    private Lesson lesson;
    private boolean status;

    public Quiz() {
    }

    public Quiz(Lesson lesson, boolean status) {
        this.lesson = lesson;
        this.status = status;
    }

    public Quiz(int quizID, Lesson lesson, boolean status) {
        this.quizID = quizID;
        this.lesson = lesson;
        this.status = status;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Quiz{" + "quizID=" + quizID + ", lesson=" + lesson + ", status=" + status + '}';
    }

}
