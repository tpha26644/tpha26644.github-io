<%-- 
    Document   : profile.jsp
    Created on : 27-Feb-2022, 21:40:47
    Author     : NHATNAM-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords"
          content="wrappixel, admin dashboard, html css dashboard, web dashboard, bootstrap 5 admin, bootstrap 5, css3 dashboard, bootstrap 5 dashboard, Ample lite admin bootstrap 5 dashboard, frontend, responsive bootstrap 5 admin template, Ample admin lite dashboard bootstrap 5 dashboard template">
    <meta name="description"
          content="Ample Admin Lite is powerful and clean admin dashboard template, inpired from Bootstrap Framework">
    <meta name="robots" content="noindex,nofollow">
    <title>Profile Admin</title>
    <link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/view/admin/plugins/images/favicon.png">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/view/admin/css/style.min.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
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
      <%@include file="topbar-header.jsp" %>
      <!-- ============================================================== -->
      <!-- End Topbar header -->
      <!-- ============================================================== -->
      <!-- ============================================================== -->
      <!-- Left Sidebar - style you can find in sidebar.scss  -->
      <!-- ============================================================== -->
      <%@include file="left-sidebar.jsp" %>
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
              <h4 class="page-title">Profile page</h4>
            </div>
            <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
              <div class="d-md-flex">
                <ol class="breadcrumb ms-auto">
                  <li><a href="#" class="fw-normal">Dashboard</a></li>
                </ol>
                <a href="https://www.wrappixel.com/templates/ampleadmin/" target="_blank"
                   class="btn btn-danger  d-none d-md-block pull-right ms-3 hidden-xs hidden-sm waves-effect waves-light text-white">Upgrade
                  to Pro</a>
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
                <div class="user-bg"> <img width="100%" alt="user" src="${pageContext.request.contextPath}/view/admin/plugins/images/large/img1.jpg">
                  <div class="overlay-box">
                    <div class="user-content">
                      <a href="javascript:void(0)">
                        <img src="${pageContext.request.contextPath}/images/${learner.image}"
                             class="thumb-lg img-circle" alt="img">
                      </a>
                      <h4 class="text-white mt-2">${account.getUsername()}</h4>
                      <!--<h5 class="text-white mt-2">info@myadmin.com</h5>-->
                    </div>
                  </div>
                </div>
                <div class="user-btm-box mt-5 d-md-flex">
                  <div class="col-md-4 col-sm-4 text-center">
                    <!--<h1>258</h1>-->
                  </div>
                  <div class="col-md-4 col-sm-4 text-center">
                    <!--<h1>125</h1>-->
                  </div>
                  <div class="col-md-4 col-sm-4 text-center">
                    <!--<h1>556</h1>-->
                  </div>
                </div>
              </div>
            </div>
            <!-- Column -->
            <!-- Column -->
            <div class="col-lg-8 col-xlg-9 col-md-12">
              <div class="card">
                <div class="card-body">
                  <form action="learner-profile?learnerID=${learner.learnerID}" method="POST" class="form-horizontal form-material">
                    <div class="form-group mb-4">
                      <label class="col-md-12 p-0">Full Name</label>
                      <div class="col-md-12 border-bottom p-0">
                        <input type="text" placeholder="Johnathan Doe" value="${learner.getFullname()}"
                               class="form-control p-0 border-0" name="name"> 
                      </div>
                    </div>
                    <div class="form-group mb-4">
                      <label class="col-md-12 p-0">Sex</label>
                      <div class="col-md-12 border-bottom p-0">
                        <input type="radio" 
                               value="1" checked
                               class="m-2" name="gender">Male
                        <input type="radio" 
                               value="0" ${learner.gender? "":"checked"}
                               class="m-2" name="gender">Female
                      </div>
                    </div>
                    <div class="form-group mb-4">
                      <label class="col-md-12 p-0">DOB</label>
                      <div class="col-md-12 border-bottom p-0">
                        <input type="date" placeholder="" 
                               value="${learner.getDob()}"
                               class="form-control p-0 border-0" name="dob">
                      </div>
                    </div>
                    <div class="form-group mb-4">
                      <label class="col-md-12 p-0">Address</label>
                      <div class="col-md-12 border-bottom p-0">
                        <input type="text" placeholder="Vietnam" 
                               value="${learner.getAddress()}"
                               class="form-control p-0 border-0" name="address">
                      </div>
                    </div>
                    <div class="form-group mb-4">
                      <label class="col-md-12 p-0">Email</label>
                      <div class="col-md-12 border-bottom p-0">
                        <input type="email" placeholder="feryt@fpt.edu.vn" 
                               value="${learner.getEmail()}"
                               class="form-control p-0 border-0" name="email">
                      </div>
                    </div>
                    <div class="form-group mb-4">
                      <label class="col-md-12 p-0">Phone No</label>
                      <div class="col-md-12 border-bottom p-0">
                        <input type="text" placeholder="123 456 7890" 
                               value="${learner.getPhone()}"
                               class="form-control p-0 border-0" name="phone">
                      </div>
                    </div>
                    <!--                    <div class="form-group mb-4">
                                          <label class="col-md-12 p-0">Message</label>
                                          <div class="col-md-12 border-bottom p-0">
                                            <textarea rows="5" class="form-control p-0 border-0"></textarea>
                                          </div>
                                        </div>-->
                    <!--                    <div class="form-group mb-4">
                                          <label class="col-sm-12">Select Country</label>
                    
                                          <div class="col-sm-12 border-bottom">
                                            <select class="form-select shadow-none p-0 border-0 form-control-line">
                                              <option>London</option>
                                              <option>India</option>
                                              <option>Usa</option>
                                              <option>Canada</option>
                                              <option>Thailand</option>
                                            </select>
                                          </div>
                                        </div>-->
                    <div class="form-group mb-4">
                      <div class="col-sm-12">
                        <input class="btn btn-success" type="submit"
                               value="Update Profile" name="update">
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
    <script src="${pageContext.request.contextPath}/view/admin/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="${pageContext.request.contextPath}/view/admin/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/view/admin/js/app-style-switcher.js"></script>
    <!--Wave Effects -->
    <script src="${pageContext.request.contextPath}/view/admin/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="${pageContext.request.contextPath}/view/admin/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="${pageContext.request.contextPath}/view/admin/js/custom.js"></script>
    <style>
      .user-bg {
          height: 200px;
      }
    </style>
  </body>
</html>
