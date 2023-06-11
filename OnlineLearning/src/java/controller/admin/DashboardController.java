/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dao.AdminDAO;
import dao.CategoryDAO;
import dao.CourseDAO;
import dao.LearnerDAO;
import dao.LectureDAO;
import dao.LessonDAO;
import dao.QuizDAO;
import entity.Account;
import entity.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NHATNAM-PC
 */
public class DashboardController extends HttpServlet {

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

        HttpSession session = request.getSession();

        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");

            if (action == null) {
                action = "dashboard";
            }

            if (action.equals("dashboard")) {
                //count data from database
                int countLecturer = new LectureDAO().totalLecturer();
                int countLearner = new LearnerDAO().totalLearner();
                int countCategory = new CategoryDAO().totalCategory();
                int countCourse = new CourseDAO().totalCourse();
                int countLesson = new LessonDAO().totalLesson();
                int countQuiz = new QuizDAO().totalQuiz();

                //set data
                request.setAttribute("countLecturer", countLecturer);
                request.setAttribute("countLearner", countLearner);
                request.setAttribute("countCategory", countCategory);
                request.setAttribute("countCourse", countCourse);
                request.setAttribute("countLesson", countLesson);
                request.setAttribute("countQuiz", countQuiz);

                request.getRequestDispatcher("../view/admin/dashboard.jsp")
                        .forward(request, response);
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
