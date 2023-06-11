/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.learner;

import dao.LearnerDAO;
import dao.LectureDAO;
import entity.Learner;
import entity.Lecture;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Duc Anh
 */
public class LearnerEditProfileController extends HttpServlet {

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
            out.println("<title>Servlet LearnerEditProfileController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LearnerEditProfileController at " + request.getContextPath() + "</h1>");
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
        int learnerID = Integer.parseInt(request.getParameter("learnerID"));
        Learner learner = new Learner();
        learner = new LearnerDAO().getOneById(learnerID);

        request.setAttribute("learner", learner);
        request.getRequestDispatcher("../view/learner/edit_profile.jsp").forward(request, response);
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

        int learnerID = Integer.parseInt(request.getParameter("learnerID"));
        String image = request.getParameter("image");
        String image_change = request.getParameter("image_change");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String address = request.getParameter("address");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));

        if (image_change.equals("")) {
            image_change += image;
        }

        Learner learner = new Learner(learnerID, fullname, image_change, gender, dob, address, email, phone);
        new LearnerDAO().updadeLearner(learner);
        response.sendRedirect("../learner/learner-profile");
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
