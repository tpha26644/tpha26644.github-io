/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Quiz;

/**
 *
 * @author NHATNAM-PC
 */
public class QuestionAndAnswer {

  private int questionID;
  private String content;
  private int correctAnswer;
  private Quiz quiz;
  private boolean status;
  private int answer;

  public QuestionAndAnswer() {
  }

  public QuestionAndAnswer(int questionID, String content, int correctAnswer, Quiz quiz, boolean status, int answer) {
    this.questionID = questionID;
    this.content = content;
    this.correctAnswer = correctAnswer;
    this.quiz = quiz;
    this.status = status;
    this.answer = answer;
  }

  public int getQuestionID() {
    return questionID;
  }

  public void setQuestionID(int questionID) {
    this.questionID = questionID;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(int correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public Quiz getQuiz() {
    return quiz;
  }

  public void setQuiz(Quiz quiz) {
    this.quiz = quiz;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public int getAnswer() {
    return answer;
  }

  public void setAnswer(int answer) {
    this.answer = answer;
  }

  @Override
  public String toString() {
    return "QuestionAndAnswer{" + "questionID=" + questionID + ", content=" + content + ", correctAnswer=" + correctAnswer + ", quiz=" + quiz + ", status=" + status + ", answer=" + answer + '}';
  }

  
}
