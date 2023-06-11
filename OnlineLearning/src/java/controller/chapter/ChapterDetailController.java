/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.chapter;

import dao.ChapterDAO;
import dao.CourseDAO;
import dao.LessonDAO;
import entity.Chapter;
import entity.Course;
import entity.Lesson;
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
 * @author Admin
 */
@WebServlet(name = "ChapterDetailController", urlPatterns = {"/ChapterDetailController"})
public class ChapterDetailController extends HttpServlet {

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
            int chapterID = Integer.parseInt(request.getParameter("chapterId"));
            int courseID = Integer.parseInt(request.getParameter("courseId"));
            ChapterDAO dao = new ChapterDAO();
            LessonDAO daoL = new LessonDAO();
            Chapter ch = new Chapter();
            ch.setChapterID(chapterID);
            ch = dao.getOne(ch);
            
            Course c = new Course();
            c.setCourseID(courseID);
            CourseDAO daoC = new CourseDAO();
            c = daoC.getOne(c);

            request.setAttribute("c", c);
            int totallesson = daoL.getTotalLessonByChapter(ch);
            ArrayList<Lesson> listL = new ArrayList<>();
            listL = daoL.getListLessonByChapter(ch);

            request.setAttribute("ch", ch);
            request.setAttribute("listL", listL);
            request.setAttribute("totallesson", totallesson);
            request.getRequestDispatcher("view/chapter/chapterdetail.jsp").forward(request, response);
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
