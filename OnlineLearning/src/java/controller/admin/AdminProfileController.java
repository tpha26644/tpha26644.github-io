/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dao.AdminDAO;
import entity.Account;
import entity.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NHATNAM-PC
 */
//@WebServlet(name = "AdminProfileController", urlPatterns = {"/admin-profile"})
public class AdminProfileController extends HttpServlet {

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
    // for using vietnamese
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    HttpSession session = request.getSession();
    AdminDAO daoA = new AdminDAO();

    try (PrintWriter out = response.getWriter()) {

      // get data from jsp
      Account accountAdmin = (Account) session.getAttribute("accountAdmin");
      String submit = request.getParameter("update");

      if (accountAdmin != null) { // check loged in?
        Admin admin = daoA.getAdminByAccount(accountAdmin);

        //send data to jsp
        request.setAttribute("accountAdmin", accountAdmin);
        request.setAttribute("admin", admin);

        if (submit == null) { // check submit or not?
          request.getRequestDispatcher("../view/admin/profile.jsp")
                  .forward(request, response);
        } else {
          //get data from jsp
          String name = request.getParameter("name");
          String genderStr = request.getParameter("gender");
          boolean gender = (genderStr.equals("1") ? true : false);
          Date dob = Date.valueOf(request.getParameter("dob"));
          String address = request.getParameter("address");
          String email = request.getParameter("email");
          String phone = request.getParameter("phone");

          //update
          daoA.updade(new Admin(admin.getAdminID(), name, gender, dob, address, email, phone));

          response.sendRedirect("profile");
        }
      } else {
        request.getRequestDispatcher("../view/admin/profile.jsp")
                .forward(request, response);
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
