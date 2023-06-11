/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import dao.AccountDAO;
import dao.AdminDAO;
import dao.LearnerDAO;
import dao.LectureDAO;
import entity.Account;
import entity.Admin;
import entity.Learner;
import entity.Lecture;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.sendEmail;

/**
 *
 * @author admin
 */
public class ResetPasswordController extends HttpServlet {
    

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
//            String submit = request.getParameter("submit");
//            if (submit == null) {
//                request.getRequestDispatcher("resetPassword.jsp");
//            }
//            else {
//                
//            }
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
        request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
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
        String emailReset = request.getParameter("emailReset");

        String error = "";
        AccountDAO accountDAO = new AccountDAO();
        AdminDAO adminDAO = new AdminDAO();
        LearnerDAO learnerDAO = new LearnerDAO();
        LectureDAO lectureDAO = new LectureDAO();
        Admin checkAdmin = new Admin();
        Learner checkLearner = new Learner();
        Lecture checkLecture = new Lecture();
        checkAdmin = adminDAO.getAdminbyEmail(emailReset);
        checkLearner = learnerDAO.getLearnerbyEmail(emailReset);
        checkLecture = lectureDAO.getLecturebyEmail(emailReset);           
        if (checkAdmin == null && checkLearner == null && checkLecture == null) {
            error = "Email does not exist!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
        } else {
            String generator = randomCaptcha();
            String subject = "Your request to change your password has been approved.";
            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">Here is your new password:</h3>\n"
                    + "    <div>Your new password is: " + generator + "</div>\n"
                    + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";
            sendEmail.send(emailReset, subject, message, "cuongtphe150306@fpt.edu.vn", "Ppthao03");
            // Sau khi gửi pass xong thì update pass lại vào bảng.
            if (checkAdmin != null) accountDAO.updatePassword(checkAdmin.getAccountID(), generator);
            if (checkLearner != null) accountDAO.updatePassword(checkLearner.getAccountID(), generator);
            if (checkLecture != null) accountDAO.updatePassword(checkLecture.getAccountID(), generator);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }      
        
        
        
        

    }
    
    public String randomCaptcha() {
        Random rd = new Random();
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = alphabet.length();
        String result = "";
        for (int i = 0; i < 8; i++) {
            int index = rd.nextInt(length);
            result += alphabet.charAt(index);
        }
        return result;
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
