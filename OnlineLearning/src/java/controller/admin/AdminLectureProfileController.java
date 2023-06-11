/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import bean.LectureAndAccount;
import dao.LectureAndAccountDAO;
import dao.LectureDAO;
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
 * @author asus
 */
public class AdminLectureProfileController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            String submit = request.getParameter("update");
            LectureDAO daoL = new LectureDAO();
            LectureAndAccountDAO daoLA = new LectureAndAccountDAO();
            
            String id = request.getParameter("lectureID");
            LectureAndAccount lecture = daoLA.getLectureById(id);
            
            if(submit == null){
                request.setAttribute("lec", lecture);
                request.getRequestDispatcher("../view/admin/lecture-profile.jsp")
                        .forward(request, response);
            }else{
                int lectureID = Integer.parseInt(id);
                String name = request.getParameter("name");
                String strGender = request.getParameter("gender");
                Boolean gender = strGender.equals("1")?true:false;
                String strDob = request.getParameter("dob");
                Date dob = Date.valueOf(strDob);
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                
                //id,name,gender,dob,address,email,phone
                
                Lecture newLecture = new Lecture(lectureID, name, gender, dob, address, email, phone);
                daoL.updateLecture(newLecture);
                
                response.sendRedirect("lecture-profile?lectureID=" + lectureID);
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
