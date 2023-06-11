/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import dao.AccountDAO;
import entity.Account;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
    request.getRequestDispatcher("login.jsp").forward(request, response);
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
    try {
      HttpSession session = request.getSession();
      String user = request.getParameter("user");
      String pass = request.getParameter("pass");

      AccountDAO accountDAO = new AccountDAO();
      Account account = accountDAO.getAccount(user, pass);

      if (account != null) {
        if (account.getRoleID() == 1) {
          session.setAttribute("accountAdmin", account);
          response.sendRedirect("admin/dashboard");
        } else if (account.getRoleID() == 2) {
          session.setAttribute("accountAdmin", account);
          response.sendRedirect("lecture/home");
        } else {

          session.setAttribute("account", account);
          response.sendRedirect("HomeController");
        }
      } else {
        request.setAttribute("mess", "Username or password is incorrect");
        request.getRequestDispatcher("login.jsp").forward(request, response);
      }

    } catch (Exception ex) {
      Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
