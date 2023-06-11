/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.healthstatus;

import bean.SymptomOfLearner;
import dao.HealthStatusDAO;
import dao.LearnerDAO;
import dao.SymptomDAO;
import entity.Account;
import entity.HealthStatus;
import entity.Learner;
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
 * @author NHATNAM-PC
 */
public class HealthDeclarationController extends HttpServlet {

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
    HealthStatusDAO hsDAO = new HealthStatusDAO();
    SymptomDAO sympDAO = new SymptomDAO();
    LearnerDAO learnerDAO = new LearnerDAO();

    try (PrintWriter out = response.getWriter()) {
      //get data from jsp
      Account account = (Account) session.getAttribute("account");
      if (account != null) { // check logged in
        request.setAttribute("account", account);
        Learner learner = learnerDAO.getLearnerByAccount(account);
        String submit = request.getParameter("submit");

        // get Symptom Of Learner from database
        ArrayList<SymptomOfLearner> listSymptomOfLearner = new ArrayList<>();
        listSymptomOfLearner = hsDAO.getListSymptomByAccount(account);

        if (submit == null) { //check sumbit or not
          request.setAttribute("listSymptomOfLearner", listSymptomOfLearner);

          request.getRequestDispatcher("view/learner/health-declaration.jsp")
                  .forward(request, response);
        } else {

          for (SymptomOfLearner symptomOfLearner : listSymptomOfLearner) {
            //get status of symptom of learner from jsp
            int symptomId = symptomOfLearner.getSymptomId();
            String healthStatus = request.getParameter("symp" + symptomId);

            if (symptomOfLearner.getHealthStatus() == 0 // change status No-->Yes
                    && healthStatus.equals("1")) {
              if (symptomOfLearner.getLearnerId() == 0) { // create new row in database
                //new health status
                HealthStatus newHealthStatus = new HealthStatus(learner.getLearnerID(), symptomId, 1);

                //insert
                hsDAO.insertHealthStatus(newHealthStatus);
              } else { //change status in database

                hsDAO.changeStatusHealthStatus(learner.getLearnerID(), symptomId, 1);
              }
            } else if (symptomOfLearner.getHealthStatus() == 1 // change status Yes-->No
                    && healthStatus.equals("0")) {

              hsDAO.changeStatusHealthStatus(learner.getLearnerID(), symptomId, 0);
            }
          }

          response.sendRedirect("HomeController");
        }
      } else {
        response.sendRedirect("login");
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
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */

}
