/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Comment;

/**
 *
 * @author asus
 */
public class LearnerAndComment {
    private Comment comment;
    private String nameLearner;

    public LearnerAndComment(Comment comment, String nameLearner) {
        this.comment = comment;
        this.nameLearner = nameLearner;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getNameLearner() {
        return nameLearner;
    }

    public void setNameLearner(String nameLearner) {
        this.nameLearner = nameLearner;
    }

    @Override
    public String toString() {
        return "LearnerAndComment{" + "comment=" + comment + ", nameLearner=" + nameLearner + '}';
    }
    
}
