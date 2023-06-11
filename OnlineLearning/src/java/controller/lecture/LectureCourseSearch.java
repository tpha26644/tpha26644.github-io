/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.lecture;

import dao.CategoryDAO;
import dao.CourseDAO;
import dao.LectureDAO;
import entity.Account;
import entity.Category;
import entity.Course;
import entity.Lecture;
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
@WebServlet(name = "LectureCourseSearch", urlPatterns = {"/lecture/course_search"})
public class LectureCourseSearch extends HttpServlet {

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
            out.println("<title>Servlet LectureCourseSearch</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LectureCourseSearch at " + request.getContextPath() + "</h1>");
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
//        String txt_search = request.getParameter("txt_search");
//        //search for course_name
//        
//        Account account = new Account();
//        account = (Account) request.getSession().getAttribute("accountAdmin");
//
//        Lecture lecture = new Lecture();
//        lecture = new LectureDAO().getLectureByAccount(account);
//
//        ArrayList<Course> list = new ArrayList<>();
//        list = new CourseDAO().searchCourse(lecture, txt_search);
//
//        request.setAttribute("lecture", lecture);
//        request.setAttribute("list", list);
//        request.getRequestDispatcher("../view/lecture/course_list_manage.jsp").forward(request, response);
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
        
        String txt_search = request.getParameter("txt_search");
        String raw_date = request.getParameter("date");
        int category_id = Integer.parseInt(request.getParameter("category"));
        
        System.out.println(txt_search);
        System.out.println(raw_date);
        
        Account account = new Account();
        account = (Account) request.getSession().getAttribute("accountAdmin");

        Lecture lecture = new Lecture();
        lecture = new LectureDAO().getLectureByAccount(account);

        ArrayList<Course> list = new ArrayList<>();
        list = new CourseDAO().searchCourse(lecture, txt_search, raw_date, category_id);
        
        ArrayList<Category> list_category = new ArrayList<Category>();
        list_category = new CategoryDAO().getAll();

        request.setAttribute("lecture", lecture);
        request.setAttribute("list", list);
        request.setAttribute("category_id", category_id);
        request.setAttribute("list_category", list_category);
        request.getRequestDispatcher("../view/lecture/course_list_manage.jsp").forward(request, response);
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
