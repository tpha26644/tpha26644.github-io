/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.account;

import dao.AccountDAO;
import dao.LearnerDAO;
import entity.Account;
import entity.Learner;
import entity.Role;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
            AccountDAO daoA = new AccountDAO();
            LearnerDAO daoL = new LearnerDAO();
            String action = request.getParameter("action");
            if (action == null) {
                action = "register";
            }
            if (action.equals("register")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    Dispatcher(request, response, "register.jsp");
                } else {
                    String name = request.getParameter("name");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String username = request.getParameter("user");
                    String password = request.getParameter("pass");
                    if (daoA.checkUnique(username) == false) {
                        response.sendRedirect("RegisterServlet");
                    } else if (name.length() > 50 || phone.length() != 10 || password.length() < 8 || password.length() > 32) {
                        response.sendRedirect("RegisterServlet");
                    } else {
//                        daoA.register(new Account(username, password, 3));
//                        String sql = "Select top 1 accountID from Account ORDER BY accountID desc";
//                        ResultSet rs = daoL.getData(sql);
//                        if (rs.next()) {
//                            int id = rs.getInt(1);
//                            daoL.register(new Learner(name, email, phone, id));
//                        }

                        Account newAccount = new Account(username, password, 3);
                        if (daoA.register(newAccount) > 0) { //if add new learner account complete
                            Account account = daoA.getAccount(username, password); //get account from database
                            Learner learner = new Learner(name, email, phone, account.getAccountID());
                            //add learner
                            daoL.register(learner);
                            HttpSession session = request.getSession();
                            session.setAttribute("account", account);
                        }
                        Dispatcher(request, response, "checkf0.jsp");
                    }
                }
            }
            if (action.equals("checkf0")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    Dispatcher(request, response, "checkf0.jsp");
                } else {
                    int sts = Integer.parseInt(request.getParameter("sts"));
                    if (sts == 1) {
                        response.sendRedirect("health-declaration");
                    } else {
                        response.sendRedirect("HomeController");
                    }
                }
            }
        }
    }

    public void Dispatcher(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
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
