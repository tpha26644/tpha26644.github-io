<%-- 
    Document   : test
    Created on : Feb 28, 2022, 3:10:25 PM
    Author     : haili
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords"
              content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Ample lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Ample admin lite dashboard bootstrap 5 dashboard template">
        <meta name="description"
              content="Ample Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
        <meta name="robots" content="noindex,nofollow">
        <title>edit_answer</title>
        <link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="../view/admin/plugins/images/favicon.png">
        <!-- Custom CSS -->
        <link href="../view/admin/plugins/bower_components/chartist/dist/chartist.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../view/admin/plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.css">
        <!-- Custom CSS -->
        <link href="../view/admin/css/style.min.css" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <link href="../css/course/add-course.css" rel="stylesheet" media="all">

    </head>
    <body>
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>

        <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
             data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">

            <header class="topbar" data-navbarbg="skin5">
                <nav class="navbar top-navbar navbar-expand-md navbar-dark">
                    <div class="navbar-header" data-logobg="skin6">
                        <p style="font-weight: bold;text-align: center;">LECTURE MANAGEMENT<p>
                            <a class="nav-toggler waves-effect waves-light text-dark d-block d-md-none"
                               href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
                    </div>
                    <div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">
                        <ul class="navbar-nav ms-auto d-flex align-items-center">
                            <li class=" in">

                            </li>
                            <li>
                                <a class="profile-pic" href="#">
                                    <img src="../images/lectures/${lecture.getImage()}" alt="user-img" width="36"
                                         class="img-circle"><span class="text-white font-medium">${lecture.getFullname()}</span></a>
                            </li>

                        </ul>
                    </div>
                </nav>
            </header>
            <aside class="left-sidebar" data-sidebarbg="skin6">
                <!-- Sidebar scroll-->
                <div class="scroll-sidebar">
                    <!-- Sidebar navigation-->
                    <nav class="sidebar-nav">
                        <ul id="sidebarnav">
                            <!-- User Profile-->
                            <li class="sidebar-item pt-2">
                                <a class="sidebar-link waves-effect waves-dark sidebar-link" href="home"
                                   aria-expanded="false">
                                    <i class="far fa-clock" aria-hidden="true"></i>
                                    <span class="hide-menu">Giao diện chính</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link waves-effect waves-dark sidebar-link" href="profile.html"
                                   aria-expanded="false">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                    <span class="hide-menu">Trang cá nhân</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link waves-effect waves-dark sidebar-link" href="../lecture/course_list"
                                   aria-expanded="false">
                                    <i class="fa fa-font" aria-hidden="true"></i>
                                    <span class="hide-menu">Các khóa học</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </aside>

            <div class="page-wrapper">
                <div class="page-breadcrumb bg-white">
                    <div class="row align-items-center">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Sửa đáp án</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                            <div class="d-md-flex">
                                <ol class="breadcrumb ms-auto">
                                    <li><a href="../lecture/quiz_detail?quizID=${question.getQuiz().getQuizID()}" class="fw-normal">Danh sách các câu hỏi</a></li>
                                </ol>
                                <a href="../LogoutController"
                                   class="btn btn-danger  d-none d-md-block pull-right ms-3 hidden-xs hidden-sm waves-effect waves-light text-white">Đăng xuất
                                </a>
                            </div>
                        </div>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <div class="card card-6">
                    <div class="card-heading" style="background-color: black;">
                        <h2 class="title">Sửa đáp án</h2>
                    </div>
                    <div class="card-body">
                        <form method="POST" action="../lecture/edit_answer">
                            <div class="form-row">
                                <div class="name">Câu hỏi</div>
                                <div class="value">
                                    <input type="hidden" name="questionID" value="${question.getQuestionID()}" />
                                    <input name="question" value="${question.getContent()}" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                    <c:forEach items="${list_answer}" var="a">
                                        <input type="hidden" name="index" value="${a.getAnswerID()}" />
                                        <label for="exampleInputEmail1">Đáp án ${a.getAnswer()}</label>
                                        <input name="answer${a.getAnswerID()}" value="${a.getAnswer_content()}" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                    </c:forEach>
                                    <div class="alert alert-success" role="alert">
                                        <label for="exampleInputEmail1">Đáp án đúng: </label>
                                        <input name="correct_answer" value="${question.getCorrectAnswer()}" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                                    </div>
                                </div>

                            </div>
                            <div class="card-footer">
                                <button class="btn btn--radius-2 btn--blue-2" type="submit"
                                        style="margin:auto;display:block;margin-bottom: 20px;">Sửa</button>
                            </div>
                        </form>
                    </div>

                </div>

                <footer class="footer text-center"> 2021 © Ample Admin brought to you by <a
                        href="https://www.wrappixel.com/">wrappixel.com</a>
                </footer>

            </div>

        </div>

        <script src="../view/admin/plugins/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="../view/admin/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <script src="../view/admin/js/app-style-switcher.js"></script>
        <script src="../view/admin/plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
        <script src="../view/admin/js/waves.js"></script>
        <script src="../view/admin/js/sidebarmenu.js"></script>
        <script src="../view/admin/js/custom.js"></script>
        <script src="../view/admin/plugins/bower_components/chartist/dist/chartist.min.js"></script>
        <script src="../view/admin/plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
        <script src="../view/admin/js/pages/dashboards/dashboard1.js"></script>
        <script src="../js/course/jquery.min.js"></script>
        <script src="../js/course/global.js"></script>
    </body>
</html>
