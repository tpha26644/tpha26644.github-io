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
public class Comment {
    private int commentID;
    private int learnerID;
    private int lessonID;
    private String content;
    private Date timeComment;
    private boolean status;

    public Comment(int commentID, int learnerID, int lessonID, String content, Date timeComment, boolean status) {
        this.commentID = commentID;
        this.learnerID = learnerID;
        this.lessonID = lessonID;
        this.content = content;
        this.timeComment = timeComment;
        this.status = status;
    }

    public Comment(int learnerID, int lessonID, String content, Date timeComment, boolean status) {;
        this.learnerID = learnerID;
        this.lessonID = lessonID;
        this.content = content;
        this.timeComment = timeComment;
        this.status = status;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeComment() {
        return timeComment;
    }

    public void setTimeComment(Date timeComment) {
        this.timeComment = timeComment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentID=" + commentID + ", learnerID=" + learnerID + ", lessonID=" + lessonID + ", content=" + content + ", timeComment=" + timeComment + ", status=" + status + '}';
    }

    
}
