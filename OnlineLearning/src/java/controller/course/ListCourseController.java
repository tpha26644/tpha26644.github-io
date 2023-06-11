/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.course;

import dao.CategoryDAO;
import dao.CourseDAO;
import dao.LearnerDAO;
import entity.Account;
import entity.Category;
import entity.Course;
import entity.Learner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class ListCourseController extends HttpServlet {

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

            Account account = (Account) session.getAttribute("account");

            //if logged in
            if (account != null) {
                //get list suggest course by learner account
                Learner learner = new LearnerDAO().getLearnerByAccount(account);
                ArrayList<Course> listCourseSuggest = new CourseDAO().getCourseBySymptomOfLearner(learner);
                Collections.shuffle(listCourseSuggest);
                //set data
                request.setAttribute("listCourseSuggest", listCourseSuggest);
            }

            CourseDAO courseDAO = new CourseDAO();
            ArrayList<Course> listCoursesTotal = courseDAO.getAllCourse();

            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }

            final int PAGE_SIZE = 20;
            int totalCourse = listCoursesTotal.size();
            int totalPage = totalCourse / PAGE_SIZE;
            if (totalCourse % PAGE_SIZE != 0) {
                totalPage++;
            }
            
            CategoryDAO dao = new CategoryDAO();

            ArrayList<Course> listCourses = courseDAO.getAllPaging(page, PAGE_SIZE);
            ArrayList<Category> listCate = dao.getAll();
            
            request.setAttribute("listCate", listCate);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("page", page);
            request.setAttribute("listCourses", listCourses);
            request.getRequestDispatcher("view/course/list.jsp").forward(request, response);
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

    //random 3 course from list suggest course
    private ArrayList<Course> getRandomCourse(Learner learner) {
        ArrayList<Course> listC = new CourseDAO().getCourseBySymptomOfLearner(learner);
        ArrayList<Course> listRandom = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Random rand = new Random(); //instance of random class
            listRandom.add(listC.get(rand.nextInt(listC.size())));
        }
        return listRandom;
    }

}
