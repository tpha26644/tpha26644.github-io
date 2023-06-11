/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.lesson;

import bean.LearnerAndComment;
import dao.ChapterDAO;
import dao.CommentDAO;
import dao.CourseDAO;
import dao.LearnerDAO;
import dao.LessonDAO;
import entity.Account;
import dao.QuizDAO;
import dao.RateDAO;
import entity.Chapter;
import entity.Comment;
import entity.Course;
import entity.Learner;
import entity.Lesson;
import entity.Quiz;
import entity.Rate;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LessonDetailController", urlPatterns = {"/LessonDetailController"})
public class LessonDetailController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("account");
            LearnerDAO daoLearner = new LearnerDAO();
            Learner learner = daoLearner.getLearnerByAccount(acc);

            int learnerId = learner.getLearnerID();
            int lessonId = Integer.parseInt(request.getParameter("lessonId"));
            int chapterId = Integer.parseInt(request.getParameter("chapterId"));
            LessonDAO daoL = new LessonDAO();
            CourseDAO daoC = new CourseDAO();
            ChapterDAO daoCh = new ChapterDAO();
            Chapter ch = new Chapter();

            ch.setChapterID(chapterId);
            ch = daoCh.getOne(ch);
            request.setAttribute("ch", ch);
            Lesson l = new Lesson();
            l.setLessonID(lessonId);
            l = daoL.getOne(l);
            request.setAttribute("l", l);
            ArrayList<Course> listC = new ArrayList<>();
            listC = daoC.getTop4Course();
            request.setAttribute("listC", listC);

            //get quiz list      
            ArrayList<Quiz> quizList = new QuizDAO().getListQuizByLesson(l);
            request.setAttribute("quizList", quizList);

            // list cmt
            CommentDAO daoCmt = new CommentDAO();

            int totalPage = daoCmt.getToTalPage(lessonId);
            request.setAttribute("totalPage", totalPage);

            String indexStr = request.getParameter("index");
            int index = 0;
            if (indexStr == null) {
                index = 1;
            } else {
                index = Integer.parseInt(indexStr);
            }
            ArrayList<LearnerAndComment> listCmt = daoCmt.pagingCmt(lessonId, index);
            request.setAttribute("listCmt", listCmt);

            //rate
            RateDAO daoRate = new RateDAO();
            int rate = daoRate.getRateByLearnerAndLesson(learnerId, lessonId);
            request.setAttribute("rate", rate);

            request.setAttribute("lessonId", lessonId);
            request.setAttribute("chapterId", chapterId);
            request.getRequestDispatcher("view/lesson/lessondetail.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("account");
        LearnerDAO daoL = new LearnerDAO();
        Learner learner = daoL.getLearnerByAccount(acc);

        int learnerId = learner.getLearnerID();
        int lessonId = Integer.parseInt(request.getParameter("lessonId"));
        int chapterId = Integer.parseInt(request.getParameter("chapterId"));
        LessonDAO daoLesson = new LessonDAO();
        CourseDAO daoC = new CourseDAO();
        ChapterDAO daoCh = new ChapterDAO();
        CommentDAO daoCmt = new CommentDAO();
        RateDAO daoRate = new RateDAO();

        Chapter ch = new Chapter();
        ch.setChapterID(chapterId);
        ch = daoCh.getOne(ch);
        request.setAttribute("ch", ch);

        Lesson l = new Lesson();
        l.setLessonID(lessonId);
        l = daoLesson.getOne(l);
        request.setAttribute("l", l);

        ArrayList<Course> listC = new ArrayList<>();
        listC = daoC.getTop4Course();
        request.setAttribute("listC", listC);

        //add cmt
        String commnet = request.getParameter("comment");
        java.util.Date date = new java.util.Date();
        Date timeComment = new Date(date.getTime());
        if (!commnet.isEmpty()) {
            Comment cmt = new Comment(learnerId, lessonId, commnet, timeComment, true);
            daoCmt.addComment(cmt);
        }
        // rate
        int rate = daoRate.getRateByLearnerAndLesson(learnerId, lessonId);
        String rateStr = request.getParameter("rating");
        int rateCurrent = 0;
        if (rateStr == null && rate == 0) {//khong chon rate
            rateCurrent = 0;
        } else if (rateStr == null && rate != 0) {//chon rate
            rateCurrent = rate;
        } else if (rateStr != null && rate == 0) {
            rateCurrent = Integer.parseInt(rateStr);
            Rate r = new Rate(learnerId, lessonId, rateCurrent, timeComment, true);
            daoRate.addRate(r);
        } else if (rateStr != null && rate != 0) {
            rateCurrent = Integer.parseInt(rateStr);
            daoRate.updateRate(rateCurrent, learnerId, lessonId);
        }

        request.setAttribute("rate", rateCurrent);
        // list cmt
        int totalPage = daoCmt.getToTalPage(lessonId);
        request.setAttribute("totalPage", totalPage);

        String indexStr = request.getParameter("index");
        int index = 0;
        if (indexStr == null) {
            index = 1;
        } else {
            index = Integer.parseInt(indexStr);
        }
        ArrayList<LearnerAndComment> listCmt = daoCmt.pagingCmt(lessonId, index);
        request.setAttribute("listCmt", listCmt);

        request.setAttribute("lessonId", lessonId);
        request.setAttribute("chapterId", chapterId);
        request.getRequestDispatcher("view/lesson/lessondetail.jsp").forward(request, response);

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
