/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.lecture;

import dao.ChapterDAO;
import dao.CourseDAO;
import dao.LectureDAO;
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
public class LectureChapterUpdateController extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Account account = new Account();
            account = (Account) request.getSession().getAttribute("accountAdmin");

            Lecture lecture = new Lecture();
            lecture = new LectureDAO().getLectureByAccount(account);

            String submit = request.getParameter("submit");
            if (submit == null) {
                int chapterID = Integer.parseInt(request.getParameter("chapterID"));
                ChapterDAO chapterDAO = new ChapterDAO();
                Chapter chapterCheck = new Chapter();
                chapterCheck.setChapterID(chapterID);
                Chapter chapter = chapterDAO.getOne(chapterCheck);

                CourseDAO courseDAO = new CourseDAO();
                Course course = courseDAO.getOne(chapter.getCourse());
                
                ArrayList<Course> listCourse = courseDAO.getAllCourse();
                
                request.setAttribute("listCourse", listCourse);
                request.setAttribute("course", course);
                request.setAttribute("chapter", chapter);
                request.setAttribute("lecture", lecture);
                request.getRequestDispatcher("view/lecture/chapter_update_manage.jsp").forward(request, response);
            }
            else {
                String chapter_name = request.getParameter("chapter_name");
                int chapter_courseID = Integer.parseInt(request.getParameter("chapter_courseID"));
                int chapterID = Integer.parseInt(request.getParameter("chapterID"));
                
                ChapterDAO chapterDAO = new ChapterDAO();
                CourseDAO courseDAO = new CourseDAO();
                Course courseCheck = new Course();
                courseCheck.setCourseID(chapter_courseID);
                Course course = courseDAO.getOne(courseCheck);
                
                Chapter chapterCheck = new Chapter();
                chapterCheck.setChapterID(chapterID);
                Chapter chapter = chapterDAO.getOne(chapterCheck);
                chapter.setChapterName(chapter_name);
                chapter.setCourse(course);
                chapterDAO.update(chapter);
                response.sendRedirect("lecture/home");
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
