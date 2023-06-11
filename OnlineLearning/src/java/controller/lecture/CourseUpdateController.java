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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CourseUpdateController", urlPatterns = {"/CourseUpdateController"})
public class CourseUpdateController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String submit = request.getParameter("submit");
            CourseDAO dao = new CourseDAO();
            if (submit == null) {
                Course c = new Course();
                int courseID = Integer.parseInt(request.getParameter("courseID"));
                c.setCourseID(courseID);
                c = dao.getOne(c);
                ArrayList<Category> list_category = new ArrayList<>();
                list_category = new CategoryDAO().getAll();
                Account account = new Account();
                account = (Account) request.getSession().getAttribute("accountAdmin");
                Lecture lecture = new Lecture();
                lecture = new LectureDAO().getLectureByAccount(account);
                request.setAttribute("lecture", lecture);
                request.setAttribute("list_category", list_category);
                request.setAttribute("c", c);
                request.getRequestDispatcher("view/course/update.jsp").forward(request, response);
            } else {
                int courseID = Integer.parseInt(request.getParameter("courseID"));
                String name = request.getParameter("course_name");
                String overview = request.getParameter("course_overview");
                String description = request.getParameter("course_description");
                String image = request.getParameter("image");
                String cate = request.getParameter("category");
                int cateID = Integer.parseInt(cate);
                Category category = new Category();
                category.setCategoryID(cateID);
                category = new CategoryDAO().getOne(category);
                Course c = new Course(image, name, overview, description, category, courseID);
                dao.update(c);
                response.sendRedirect("lecture/course_list");
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
