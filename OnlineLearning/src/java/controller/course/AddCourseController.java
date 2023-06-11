/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.course;

import dao.CategoryDAO;
import dao.CourseDAO;
import dao.LectureDAO;
import entity.Account;
import entity.Category;
import entity.Course;
import entity.Lecture;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author haili
 */
@WebServlet(name = "AddCourseController", urlPatterns = {"/course/add"})
public class AddCourseController extends HttpServlet {

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
            out.println("<title>Servlet AddCourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCourseController at " + request.getContextPath() + "</h1>");
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
        ArrayList<Category> list_category = new ArrayList<>();
        list_category = new CategoryDAO().getAll();

        Account a = new Account();
        a = (Account)request.getSession().getAttribute("accountAdmin");
        Lecture lecture = new Lecture();
        lecture = new LectureDAO().getLectureByAccount(a);
        
        request.setAttribute("lecture", lecture);
        request.setAttribute("list_category", list_category);
        request.getRequestDispatcher("../view/course/add.jsp").forward(request, response);
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
        
        Account a = new Account();
        a = (Account)request.getSession().getAttribute("accountAdmin");
        Lecture lecture = new Lecture();
        lecture = new LectureDAO().getLectureByAccount(a);
        
        String course_name = request.getParameter("course_name");
        String course_overview = request.getParameter("course_overview");
        String course_description = request.getParameter("course_description");
        String image = request.getParameter("image");
        
        int raw_category = Integer.parseInt(request.getParameter("category"));
        Category category = new Category();
        category.setCategoryID(raw_category);
        category = new CategoryDAO().getOne(category);

        long millis = System.currentTimeMillis();
        Date createDate = new Date(millis);
        
        Course course = new Course(image, course_name, course_overview, course_description, createDate, lecture, category, true);
        
        new CourseDAO().insert(course);
        response.sendRedirect("../lecture/course_list");
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
