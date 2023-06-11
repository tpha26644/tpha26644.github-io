/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import dao.AccountDAO;
import dao.LearnerDAO;
import entity.Account;
import entity.Learner;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class ChangePasswordController extends HttpServlet {

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
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.getRequestDispatcher("changePassword.jsp").forward(request, response);
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
        String id = request.getParameter("id");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String retypeNewPassword = request.getParameter("retypeNewPassword");
        String error = "";
        int check = 0;
        AccountDAO accountDAO = new AccountDAO();
        LearnerDAO learnerDAO = new LearnerDAO();
        Learner learner = learnerDAO.getOneById(Integer.parseInt(id));
        Account account = accountDAO.getOneById(learner.getAccountID());
        if (!accountDAO.toMD5(oldPassword).equals(account.getPassword())) {
            error = "Old password is not correct!";
            request.setAttribute("error", error);
            request.setAttribute("id", id);
            check = 1;
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }
        if (newPassword.length() != 8) {
            error = "Your new password must be 8 character!";
            request.setAttribute("id", id);
            request.setAttribute("error", error);
            check = 1;
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }
        if (!newPassword.equals(retypeNewPassword)) {
            error = "Retype password is not the same with new password!";
            request.setAttribute("id", id);
            request.setAttribute("error", error);
            check = 1;
            request.getRequestDispatcher("changePassword.jsp").forward(request, response);
        }

        // learner password khac voi old password thi bat nhap lai, con oke thi doi?
        if (check == 0) {
            accountDAO.updatePassword(account.getAccountID(), newPassword);
            response.sendRedirect("learner/learner-profile");
        }        

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
