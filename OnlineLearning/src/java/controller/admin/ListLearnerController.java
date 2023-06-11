/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import bean.LearnerAndAccount;
import dao.AccountDAO;
import dao.LearnerAndAccountDAO;
import dao.LearnerDAO;
import entity.Account;
import entity.Learner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NHATNAM-PC
 */
//@WebServlet(name = "ListLearnerController", urlPatterns = {"/admin/list-learner"})
public class ListLearnerController extends HttpServlet {

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

    LearnerAndAccountDAO dao = new LearnerAndAccountDAO();
    AccountDAO daoA = new AccountDAO();
    LearnerDAO daoL = new LearnerDAO();
    ArrayList<LearnerAndAccount> listLearner = new ArrayList<>();

    try (PrintWriter out = response.getWriter()) {
      //get data
      String action = request.getParameter("action");

      //get list learner
      listLearner = dao.getAll();

      //set data
      request.setAttribute("listLearner", listLearner);

      if (action == null) {
        request.getRequestDispatcher("../view/admin/list-learner.jsp")
                .forward(request, response);
      }

      //change status of learner
      if (action != null && action.equals("changeStatus")) {
        //get data
        int learnerID = Integer.parseInt(request.getParameter("learnerID"));
        int status = Integer.parseInt(request.getParameter("status"));
        boolean booStatus = status == 1 ? true : false;

        //update
        dao.changeStatus(learnerID, booStatus);

        response.sendRedirect("list-learner");
      }

      // add new learner
      if (action != null && action.equals("addLearnerByAdmin")) {
        //get data from jsp
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (daoA.checkUnique(username) == false) { //check username already exist or not?
          String err = "username already exits";

          request.setAttribute("err", err);
          request.setAttribute("name", name);
          request.setAttribute("username", username);
          request.setAttribute("password", password);
          request.setAttribute("rePassword", rePassword);
          request.setAttribute("email", email);
          request.setAttribute("phone", phone);
          request.getRequestDispatcher("../view/admin/list-learner.jsp")
                  .forward(request, response);
        } else if (name.length() > 50 //another check
                || phone.length() != 10
                || password.length() < 8
                || password.length() > 32) {
          String err = "something wrong";

          request.setAttribute("err", err);
          request.setAttribute("name", name);
          request.setAttribute("username", username);
          request.setAttribute("password", password);
          request.setAttribute("rePassword", rePassword);
          request.setAttribute("email", email);
          request.setAttribute("phone", phone);
          request.getRequestDispatcher("../view/admin/list-learner.jsp")
                  .forward(request, response);
        } else { // data ok

          Account account = new Account(username, password, 3);

          if (daoA.register(account) > 0) { //if add new learner account complete

            Account a = daoA.getAccount(username, password); //get account from database

            Learner learner = new Learner(name, email, phone, a.getAccountID());

            //add learner
            daoL.register(learner);
          }

          response.sendRedirect("list-learner");
        }
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
