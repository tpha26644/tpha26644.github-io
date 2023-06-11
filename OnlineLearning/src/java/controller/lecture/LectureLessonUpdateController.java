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
import entity.Lesson;
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
public class LectureLessonUpdateController extends HttpServlet {

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
                int lessonID = Integer.parseInt(request.getParameter("lessonID"));
                LessonDAO lessonDAO = new LessonDAO();
                Lesson lessonCheck = new Lesson();
                lessonCheck.setLessonID(lessonID);
                Lesson lesson = lessonDAO.getOne(lessonCheck);

                ChapterDAO chapterDAO = new ChapterDAO();
                Chapter chapter = chapterDAO.getOne(lesson.getChapter());
                
                ArrayList<Chapter> listChapter = chapterDAO.getAllChapters();
                
                request.setAttribute("listChapter", listChapter);
                request.setAttribute("lesson", lesson);
                request.setAttribute("chapter", chapter);
                request.setAttribute("lecture", lecture);
                request.getRequestDispatcher("view/lecture/lesson_update_manage.jsp").forward(request, response);
            }
            else {
                String lesson_name = request.getParameter("lesson_name");
                int lesson_chapterID = Integer.parseInt(request.getParameter("lesson_chapterID"));
                String lesson_reading = request.getParameter("lesson_reading");
                String lesson_video = request.getParameter("lesson_video");
                int lessonID = Integer.parseInt(request.getParameter("lessonID"));
                
                LessonDAO lessonDAO = new LessonDAO();
                ChapterDAO chapterDAO = new ChapterDAO();
                Chapter chapterCheck = new Chapter();
                chapterCheck.setChapterID(lesson_chapterID);
                Chapter chapter = chapterDAO.getOne(chapterCheck);
                
                Lesson lessonCheck = new Lesson();
                lessonCheck.setLessonID(lessonID);
                Lesson lesson = lessonDAO.getOne(lessonCheck);
                lesson.setTitle(lesson_name);
                lesson.setChapter(chapter);
                lesson.setReading(lesson_reading);
                lesson.setVideo(lesson_video);
                lessonDAO.update(lesson);
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
