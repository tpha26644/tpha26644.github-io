/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Duc Anh
 */
public class Answer {

    private int answerID;
    private Question question;
    private int answer;
    private boolean status;
    private String answer_content;

    public Answer() {
    }

    public Answer(Question question, int answer, boolean status, String answer_content) {
        this.question = question;
        this.answer = answer;
        this.status = status;
        this.answer_content = answer_content;
    }

    public Answer(int answerID, Question question, int answer, boolean status, String answer_content) {
        this.answerID = answerID;
        this.question = question;
        this.answer = answer;
        this.status = status;
        this.answer_content = answer_content;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAnswer_content() {
        return answer_content;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    @Override
    public String toString() {
        return "Answer{" + "answerID=" + answerID + ", question=" + question + ", answer=" + answer + ", status=" + status + ", answer_content=" + answer_content + '}';
    }

}
