/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.learner;

import dao.CourseDAO;
import dao.EnrollDAO;
import dao.HealthStatusDAO;
import dao.LearnerDAO;
import dao.SymptomDAO;
import entity.Account;
import entity.Course;
import entity.Enroll;
import entity.HealthStatus;
import entity.Learner;
import entity.Symptom;
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
public class LearnerProfileController extends HttpServlet {

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
            out.println("<title>Servlet LearnerProfileController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LearnerProfileController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        Learner learner = new Learner();
        learner = new LearnerDAO().getLearnerByAccount(account);

        //Symptom
        ArrayList<Symptom> list_symtomp = new ArrayList<>();
        list_symtomp = new SymptomDAO().getListSymptomByLearner(learner);

        if (list_symtomp == null || list_symtomp.size() == 0) {
            request.setAttribute("mess", "Không bị nhiễm coivd - 19");
        }
        //Course
        ArrayList<Enroll> list_enroll = new ArrayList<>();
        list_enroll = new EnrollDAO().getListEnrollByLearnerID(learner.getLearnerID());
        
        ArrayList<Course> list_course = new ArrayList<>();
        list_course = new CourseDAO().getAllCourse();
        
        request.setAttribute("list_symtomp", list_symtomp);
        request.setAttribute("learner", learner);
        request.setAttribute("id", learner.getLearnerID());
        request.setAttribute("list_enroll", list_enroll);
        request.setAttribute("list_course", list_course);

        request.getRequestDispatcher("../view/learner/learner-profile.jsp").forward(request, response);

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
