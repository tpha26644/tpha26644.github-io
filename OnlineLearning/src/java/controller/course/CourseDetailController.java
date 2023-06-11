/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.course;

import dao.CategoryDAO;
import dao.ChapterDAO;
import dao.CourseDAO;
import dao.EnrollDAO;
import dao.LearnerDAO;
import dao.LessonDAO;
import dao.QuizDAO;
import entity.Account;
import entity.Category;
import entity.Chapter;
import entity.Course;
import entity.Learner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Linh
 */
public class CourseDetailController extends HttpServlet {

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
        String courseId = request.getParameter("courseId");
        LearnerDAO daoL = new LearnerDAO();
        EnrollDAO daoE = new EnrollDAO();
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        int accountID = account.getAccountID();
        Learner lrn = new Learner();
        lrn = daoL.getLearnerByAccount(account);
        request.setAttribute("learnerID", lrn.getLearnerID());
        Course c = new Course();
        c.setCourseID(Integer.parseInt(courseId));
        
        CourseDAO dao = new CourseDAO();
        c = dao.getOne(c);
        
        int total_chapter = new ChapterDAO().getTotalChapterByCourse(c);
        int total_lesson = new LessonDAO().getTotalLessonByCourse(c);
        int total_quiz = new QuizDAO().getTotalQuizBycourse(c);
        
        ArrayList<Chapter> list_chapter = new ArrayList<>();
        list_chapter = new ChapterDAO().getListChapterByCourse(c);
        
        request.setAttribute("c", c);
        request.setAttribute("total_chapter", total_chapter);
        request.setAttribute("total_lesson", total_lesson);
        request.setAttribute("total_quiz", total_quiz);
        request.setAttribute("list_chapter", list_chapter);
        request.getRequestDispatcher("../view/course/course-details.jsp").forward(request, response);
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
