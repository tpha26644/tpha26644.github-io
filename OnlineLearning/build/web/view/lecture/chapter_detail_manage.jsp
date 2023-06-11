<%-- 
    Document   : test
    Created on : Feb 28, 2022, 3:10:25 PM
    Author     : haili
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Danh sách các bài học</title>
        <link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="view/admin/plugins/images/favicon.png">
        <!-- Custom CSS -->
        <link href="view/admin/plugins/bower_components/chartist/dist/chartist.min.css" rel="stylesheet">
        <link rel="stylesheet" href="view/admin/plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.css">
        <!-- Custom CSS -->
        <link href="view/admin/css/style.min.css" rel="stylesheet">
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
            <!--header-->
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
                                <form role="search" action="lesson_search" method="POST" class="app-search d-none d-md-block me-3">
                                    <input type="text" placeholder="Tìm..." class="form-control mt-0" name="txt_search">                                    
                                    <input type="hidden" name="chapterID" value="${chapter.getChapterID()}" />
                                    <button type="submit" style="border: none;">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </form>
                            </li>
                            <li>
                                <a class="profile-pic" href="#">
                                    <img src="images/lectures/${lecture.getImage()}" alt="user-img" width="36"
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
                                <a class="sidebar-link waves-effect waves-dark sidebar-link" href="lecture/home"
                                   aria-expanded="false">
                                    <i class="far fa-clock" aria-hidden="true"></i>
                                    <span class="hide-menu">Giao diện chính</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link waves-effect waves-dark sidebar-link" href="lecture/lecture_profile?lectureID=${lecture.getLectureID()}"
                                   aria-expanded="false">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                    <span class="hide-menu">Trang cá nhân</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link waves-effect waves-dark sidebar-link" href="lecture/course_list"
                                   aria-expanded="false">
                                    <i class="fa fa-font" aria-hidden="true"></i>
                                    <span class="hide-menu">Các khóa học</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </aside>
            <!--header-end-->
            <div class="page-wrapper">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="page-breadcrumb bg-white">
                    <div class="row align-items-center">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Danh sách các bài giảng</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                            <div class="d-md-flex">
                                <ol class="breadcrumb ms-auto">
                                    <li><a href="list-chapter-lecture?courseID=${chapter.getCourse().getCourseID()}" class="fw-normal">Danh sách các chương</a></li>
                                </ol>
                                <a href="LogoutController"
                                   class="btn btn-danger  d-none d-md-block pull-right ms-3 hidden-xs hidden-sm waves-effect waves-light text-white">Đăng xuất
                                </a>
                            </div>
                        </div>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Container fluid  -->
                <!-- ============================================================== -->
                <div class="container-fluid">
                    <!-- ============================================================== -->
                    <!-- Start Page Content -->
                    <!-- ============================================================== -->
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="white-box">
                                <h3 class="box-title">Chương: ${chapter.getChapterName()} gồm các bài giảng: </h3>
                                <button class="btn d-grid btn-info text-white"><a href="lesson/add?chapterID=${chapter.getChapterID()}" style="text-decoration: none;color: White;">Thêm bài học mới</a></button>
                                <div class="table-responsive">
                                    <table class="table text-nowrap">
                                        <thead>
                                            <tr>
                                                <th class="border-top-0">STT</th>
                                                <th class="border-top-0">Tiêu đề</th>
                                                <th class="border-top-0">Details</th>
                                                <th class="border-top-0">Edit</th>
                                                <th class="border-top-0">Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list_lesson}" var="l" varStatus="status">
                                                <tr>
                                                    <td>${status.count}</td>
                                                    <td>${l.getTitle()}</td>
                                                    <td><button class="btn d-grid btn-info text-white"><a href="lecture/lesson_detail?lessonID=${l.getLessonID()}" style="text-decoration: none;color: white;">Details</a></button></td>
                                                    <td><button class="btn d-grid btn-warning text-white"><a href="update-lesson-lecture?lessonID=${l.getLessonID()}" style="text-decoration: none;color: white;">Edit</a></button></td>
                                                    <td><button class="btn d-grid btn-danger text-white"><a href="lecture/delete_lesson?lessonID=${l.getLessonID()}" style="text-decoration: none;color: white;">Delete</a></button></td>
                                                </tr>
                                            </c:forEach>


                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- End PAge Content -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Right sidebar -->
                    <!-- ============================================================== -->
                    <!-- .right-sidebar -->
                    <!-- ============================================================== -->
                    <!-- End Right sidebar -->
                    <!-- ============================================================== -->
                </div>
                <!-- ============================================================== -->
                <!-- End Container fluid  -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- footer -->
                <!-- ============================================================== -->
                <footer class="footer text-center"> 2021 © Ample Admin brought to you by <a
                        href="https://www.wrappixel.com/">wrappixel.com</a>
                </footer>
                <!-- ============================================================== -->
                <!-- End footer -->
                <!-- ============================================================== -->
            </div>

        </div>

        <script src="view/admin/plugins/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="view/admin/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <script src="view/admin/js/app-style-switcher.js"></script>
        <script src="view/admin/plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
        <script src="view/admin/js/waves.js"></script>
        <script src="view/admin/js/sidebarmenu.js"></script>
        <script src="view/admin/js/custom.js"></script>
        <script src="view/admin/plugins/bower_components/chartist/dist/chartist.min.js"></script>
        <script src="view/admin/plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
        <script src="view/admin/js/pages/dashboards/dashboard1.js"></script>
    </body>
</html>
