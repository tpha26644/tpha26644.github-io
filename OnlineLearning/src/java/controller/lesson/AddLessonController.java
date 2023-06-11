/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.lesson;

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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duc Anh
 */
public class AddLessonController extends HttpServlet {

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
            out.println("<title>Servlet AddLessonController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddLessonController at " + request.getContextPath() + "</h1>");
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
        
        int chapterID = Integer.parseInt(request.getParameter("chapterID"));
        
        Chapter chapter = new Chapter();
        chapter.setChapterID(chapterID);
        chapter = new ChapterDAO().getOne(chapter);

        Course course = new Course();
        course.setCourseID(chapter.getCourse().getCourseID());
        course = new CourseDAO().getOne(course);

        request.setAttribute("chapter", chapter);
        request.setAttribute("course", course);
        request.setAttribute("lecture", lecture);
        request.getRequestDispatcher("../view/lesson/add.jsp").forward(request, response);
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
        
        int chapter_id = Integer.parseInt(request.getParameter("chapter_id"));
        String title = request.getParameter("title");
        String reading = request.getParameter("reading");
        String video = request.getParameter("video");

        Chapter chapter = new Chapter();
        chapter.setChapterID(chapter_id);
        chapter = new ChapterDAO().getOne(chapter);

        Lesson lesson = new Lesson(title, reading, video, chapter, true);
        new LessonDAO().insert(lesson);
        response.sendRedirect("../detail-chapter-lecture?chapterID="+chapter_id);
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
