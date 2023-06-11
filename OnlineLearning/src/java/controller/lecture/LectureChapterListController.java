/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.lecture;

import dao.ChapterDAO;
import dao.CourseDAO;
import dao.LectureDAO;
import dao.LessonDAO;
import entity.Account;
import entity.Chapter;
import entity.Course;
import entity.Lecture;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class LectureChapterListController extends HttpServlet {

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
            Account account = new Account();
            account = (Account) request.getSession().getAttribute("accountAdmin");

            Lecture lecture = new Lecture();
            lecture = new LectureDAO().getLectureByAccount(account);
            int courseID = Integer.parseInt(request.getParameter("courseID"));
            CourseDAO courseDAO = new CourseDAO();
            Course courseCheck = new Course();
            courseCheck.setCourseID(courseID);
            Course course = courseDAO.getOne(courseCheck);

            ChapterDAO chapterDAO = new ChapterDAO();
            ArrayList<Chapter> listChapter = chapterDAO.getListChapterByCourse(course);
            request.setAttribute("course", course);
            request.setAttribute("listChapter", listChapter);
            request.setAttribute("lecture", lecture);
            request.setAttribute("courseID", courseID);
            request.getRequestDispatcher("view/lecture/chapter_list_manage.jsp").forward(request, response);
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
