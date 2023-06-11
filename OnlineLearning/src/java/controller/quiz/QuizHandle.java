/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.quiz;

import bean.QuestionAndAnswer;
import dao.AnswerDAO;
import dao.QuestionAndAnswerDAO;
import dao.QuestionDAO;
import entity.Answer;
import entity.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NHATNAM-PC
 */
public class QuizHandle extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      QuestionAndAnswerDAO daoQt = new QuestionAndAnswerDAO();
      AnswerDAO daoAns = new AnswerDAO();
      ArrayList<QuestionAndAnswer> questions = new ArrayList<>();
      ArrayList<Answer> answers = new ArrayList<>();

      String action = request.getParameter("action");
      int quizID = Integer.parseInt(request.getParameter("quizID"));
      boolean showResult = false;

      questions = daoQt.getQuestionByQuizID(quizID);
      answers = daoAns.getAnswerByQuizID(quizID);

      request.setAttribute("quizID", quizID);
      request.setAttribute("questions", questions);
      request.setAttribute("answers", answers);
      request.setAttribute("showResult", showResult);

      if (action == null) {
        action = "handleQuiz";
      }

      if (action.equals("handleQuiz")) {
        request.getRequestDispatcher("/view/quiz/quiz-handle.jsp").forward(request, response);
      }

      if (action.equals("finishQuiz")) {
        showResult = true;
        int countCorrectAns = 0;

        for (QuestionAndAnswer question : questions) {
          String ansStr = request.getParameter(String.valueOf(question.getQuestionID()));
          if (ansStr != null) {
            int ansInt = Integer.parseInt(ansStr);
            question.setAnswer(ansInt);
            System.out.println(question);
            if (ansInt == question.getCorrectAnswer()) {
              countCorrectAns++;
            }
          }
        }

        request.setAttribute("questions", questions);
        request.setAttribute("countCorrectAns", countCorrectAns);
        request.setAttribute("showResult", showResult);
        request.getRequestDispatcher("/view/quiz/quiz-handle.jsp").forward(request, response);
      }
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
