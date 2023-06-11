/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.lecture;

import dao.LectureDAO;
import dao.LessonDAO;
import dao.QuizDAO;
import entity.Account;
import entity.Lecture;
import entity.Lesson;
import entity.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duc Anh
 */
public class LectureLessonDetailController extends HttpServlet {

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
            out.println("<title>Servlet LectureLessonDetailController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LectureLessonDetailController at " + request.getContextPath() + "</h1>");
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
        account = (Account)request.getSession().getAttribute("accountAdmin");
        
        Lecture lecture = new Lecture();
        lecture = new LectureDAO().getLectureByAccount(account);
        
        int lessonID =Integer.parseInt(request.getParameter("lessonID"));
        Lesson lesson = new Lesson();
        lesson.setLessonID(lessonID);
        lesson = new LessonDAO().getOne(lesson);
        
        ArrayList<Quiz> list_quiz = new ArrayList<Quiz>();
        list_quiz = new QuizDAO().getQuizByLesson(lessonID);
        
        request.setAttribute("lecture", lecture);
        request.setAttribute("lesson", lesson);
        request.setAttribute("list_quiz", list_quiz);
        request.getRequestDispatcher("../view/lecture/lesson_detail_manage.jsp").forward(request, response);
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
