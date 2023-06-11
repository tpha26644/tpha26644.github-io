/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dao.AccountDAO;
import dao.LectureDAO;
import entity.Account;
import entity.Lecture;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class AdminAddLectureController extends HttpServlet {

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
        request.getRequestDispatcher("../view/admin/addLecture.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String fullname = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            AccountDAO accountDAO = new AccountDAO();
            LectureDAO lectureDAO = new LectureDAO();
            if (!username.isEmpty() && !password.isEmpty() && !fullname.isEmpty()
                    && !email.isEmpty() && !phone.isEmpty()) {
                if (!accountDAO.checkUnique(username)) {
                    request.setAttribute("registerFailed", "Username was existed!");
                    request.getRequestDispatcher("../view/admin/addLecture.jsp").forward(request, response);
                } else if (phone.length() != 10 || password.length() < 8 || password.length() > 32) {
                    request.setAttribute("registerFailed", "Phone must have 10 digits or password must have length 8-32 digits!");
                    request.getRequestDispatcher("../view/admin/addLecture.jsp").forward(request, response);
                } else {
                    accountDAO.addLecture(new Account(username, password, 2));
                    Account currentAccount = accountDAO.getAccount(username, password);
                    Lecture lecture = new Lecture(fullname, email, phone, currentAccount.getAccountID());
                    lectureDAO.addLectureByAdmin(lecture);
                    response.sendRedirect("list-lecture");
                }
            } else {
                request.setAttribute("registerFailed", "All field must be not empty!");
                request.getRequestDispatcher("../view/admin/addLecture.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
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
