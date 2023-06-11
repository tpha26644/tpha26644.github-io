/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.lecture;

import dao.AnswerDAO;
import dao.LectureDAO;
import dao.QuestionDAO;
import dao.QuizDAO;
import entity.Account;
import entity.Answer;
import entity.Lecture;
import entity.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duc Anh
 */
@WebServlet(name = "LectureAnswerAddController", urlPatterns = {"/lecture/quiz_answer"})
public class LectureAnswerAddController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LectureAnswerAddController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LectureAnswerAddController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        Account account = new Account();
        account = (Account) request.getSession().getAttribute("accountAdmin");

        Lecture lecture = new Lecture();
        lecture = new LectureDAO().getLectureByAccount(account);

        int questionID = Integer.parseInt(request.getParameter("questionID"));
        Question question = new QuestionDAO().getOne(questionID);
        
        int index = new AnswerDAO().countAnswerByQuestionID(questionID);

        request.setAttribute("lecture", lecture);
        request.setAttribute("question", question);
        request.setAttribute("index", index);
        request.getRequestDispatcher("../view/lecture/answer_add.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        int questionID = Integer.parseInt(request.getParameter("questionID"));
        int correct_answer = Integer.parseInt(request.getParameter("correct_answer"));
        Question question = new QuestionDAO().getOne(questionID);

        ArrayList<Answer> list_answer = new ArrayList<>();
        String[] index = request.getParameterValues("index");
        if (correct_answer > index.length) {
            request.setAttribute("mess", "Đáp án đúng chưa chính xác");
            response.sendRedirect("../lecture/quiz_answer?questionID=" + questionID);
        } else {
            for (String in : index) {
                String answer = request.getParameter("answer" + in);
                Answer a = new Answer(question, Integer.parseInt(in),
                         true, answer);
                list_answer.add(a);
            }
            new QuizDAO().insertCorrectAnswer(correct_answer, questionID);
            new AnswerDAO().insert(list_answer);
            response.sendRedirect("../lecture/quiz_detail?quizID=" + question.getQuiz().getQuizID());
        }
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
