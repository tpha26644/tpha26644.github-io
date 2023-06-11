<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html dir="ltr" lang="en">

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
        <title>lecture_profile</title>
        <link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="../view/admin/plugins/images/favicon.png">
        <!-- Custom CSS -->
        <link href="../view/admin/plugins/bower_components/chartist/dist/chartist.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../view/admin/plugins/bower_components/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.css">
        <!-- Custom CSS -->
        <link href="../view/admin/css/style.min.css" rel="stylesheet">
    </head>

    <body>
        <!-- ============================================================== -->
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Main wrapper - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
             data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
            <!-- ============================================================== -->
            <!-- Topbar header - style you can find in pages.scss -->
            <!-- ============================================================== -->
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
            <!-- ============================================================== -->
            <!-- End Topbar header -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Left Sidebar - style you can find in sidebar.scss  -->
            <!-- ============================================================== -->
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
                                <a class="sidebar-link waves-effect waves-dark sidebar-link" href="../lecture/lecture_profile?lectureID=${lecture.getLectureID()}"
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
            <!-- ============================================================== -->
            <!-- End Left Sidebar - style you can find in sidebar.scss  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Page wrapper  -->
            <!-- ============================================================== -->
            <div class="page-wrapper">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="page-breadcrumb bg-white">
                    <div class="row align-items-center">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">Thông tin cá nhân</h4>
                        </div>
                        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                            <div class="d-md-flex">
                                <ol class="breadcrumb ms-auto">
                                    <li><a href="../lecture/home" class="fw-normal">Giao diện chính</a></li>
                                </ol>
                                <a href="../LogoutController"
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
                    <!-- Row -->
                    <div class="row">
                        <!-- Column -->
                        <div class="col-lg-4 col-xlg-3 col-md-12">
                            <div class="white-box">
                                <div class="user-bg"> <img width="100%" alt="user" src="../admin/plugins/images/large/img1.jpg">
                                    <div class="overlay-box">
                                        <div class="user-content">
                                            <a href="javascript:void(0)"><img src="../images/lectures/${lecture.getImage()}"
                                                                              class="thumb-lg img-circle" alt="img"></a>
                                            <h4 class="text-white mt-2">${sessionScope.accountAdmin.getUsername()}</h4>
                                            <h5 class="text-white mt-2">${lecture.getEmail()}</h5>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                        <!-- Column -->
                        <!-- Column -->
                        <div class="col-lg-8 col-xlg-9 col-md-12">
                            <div class="card">
                                <div class="card-body">
                                    <form class="form-horizontal form-material">
                                        <div class="form-group mb-4">
                                            <label class="col-md-12 p-0">Họ và tên</label>
                                            <div class="col-md-12 border-bottom p-0">
                                                <p>${lecture.getFullname()}</p>
                                            </div>
                                        </div>
                                        <div class="form-group mb-4">
                                            <label for="example-email" class="col-md-12 p-0">Email</label>
                                            <div class="col-md-12 border-bottom p-0">
                                                <p>${lecture.getEmail()}</p>
                                            </div>
                                        </div>
                                        <div class="form-group mb-4">
                                            <label class="col-md-12 p-0">Số điện thoại</label>
                                            <div class="col-md-12 border-bottom p-0">
                                                <p>${lecture.getPhone()}</p>
                                            </div>
                                        </div>
                                        <div class="form-group mb-4">
                                            <label class="col-md-12 p-0">Ngày sinh</label>
                                            <div class="col-md-12 border-bottom p-0">
                                                <p>${lecture.getDob()}</p>
                                            </div>
                                        </div>
                                        <div class="form-group mb-4">
                                            <label class="col-md-12 p-0">Địa chỉ</label>
                                            <div class="col-md-12 border-bottom p-0">
                                                <p>${lecture.getAddress()}</p>
                                            </div>
                                        </div>
                                        <div class="form-group mb-4">
                                            <label class="col-md-12 p-0">Giới tính</label>
                                            <div class="col-md-12 border-bottom p-0">
                                                <p>${lecture.isGender() == true ? "Nam":"Nữ"}</p>
                                            </div>
                                        </div>
                                        <div class="form-group mb-4">
                                            <div class="col-sm-12">
                                                <button class="btn btn-success"><a href="../lecture/edit_profile?lectureID=${lecture.getLectureID()}" style="text-decoration: none;color: white;">Sửa</a></button>
                                            </div>
                                        </div>
                                </div>

                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                </div>
                <!-- Row -->
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
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
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
</body>

</html>