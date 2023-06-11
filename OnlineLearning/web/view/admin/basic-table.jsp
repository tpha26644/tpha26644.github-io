<%-- 
    Document   : basic-table
    Created on : 27-Feb-2022, 21:50:50
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
    <title>Basic Table</title>
    <link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
    <!-- Favicon icon -->
    <link rel="icon" type="${pageContext.request.contextPath}/view/admin/image/png" sizes="16x16" href="${pageContext.request.contextPath}/view/admin/plugins/images/favicon.png">
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
              <h4 class="page-title">Basic Table</h4>
            </div>
            <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
              <div class="d-md-flex">
<!--                <ol class="breadcrumb ms-auto">
                  <li><a href="#" class="fw-normal">Dashboard</a></li>
                </ol>
                <a href="https://www.wrappixel.com/templates/ampleadmin/" target="_blank"
                   class="btn btn-danger  d-none d-md-block pull-right ms-3 hidden-xs hidden-sm waves-effect waves-light text-white">Upgrade
                  to Pro</a>-->
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
                <h3 class="box-title">Basic Table</h3>
                <p class="text-muted">Add class <code>.table</code></p>
                <div class="table-responsive">
                  <table class="table text-nowrap">
                    <thead>
                      <tr>
                        <th class="border-top-0">#</th>
                        <th class="border-top-0">First Name</th>
                        <th class="border-top-0">Last Name</th>
                        <th class="border-top-0">Username</th>
                        <th class="border-top-0">Role</th>
                        <th class="border-top-0">Details</th>
                        <th class="border-top-0">Edit</th>
                        <th class="border-top-0">Delete</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>Deshmukh</td>
                        <td>Prohaska</td>
                        <td>@Genelia</td>
                        <td>admin</td>
                        <td><button class="btn d-grid btn-info text-white">Details</button></td>
                        <td><button class="btn d-grid btn-warning text-white">Edit</button></td>
                        <td><button class="btn d-grid btn-danger text-white">Delete</button></td>
                      </tr>
                      <tr>
                        <td>2</td>
                        <td>Deshmukh</td>
                        <td>Gaylord</td>
                        <td>@Ritesh</td>
                        <td>member</td>
                        <td><button class="btn d-grid btn-info text-white">Details</button></td>
                        <td><button class="btn d-grid btn-warning text-white">Edit</button></td>
                        <td><button class="btn d-grid btn-danger text-white">Delete</button></td>
                      </tr>
                      <tr>
                        <td>3</td>
                        <td>Sanghani</td>
                        <td>Gusikowski</td>
                        <td>@Govinda</td>
                        <td>developer</td>
                        <td><button class="btn d-grid btn-info text-white">Details</button></td>
                        <td><button class="btn d-grid btn-warning text-white">Edit</button></td>
                        <td><button class="btn d-grid btn-danger text-white">Delete</button></td>
                      </tr>
                      <tr>
                        <td>4</td>
                        <td>Roshan</td>
                        <td>Rogahn</td>
                        <td>@Hritik</td>
                        <td>supporter</td>
                        <td><button class="btn d-grid btn-info text-white">Details</button></td>
                        <td><button class="btn d-grid btn-warning text-white">Edit</button></td>
                        <td><button class="btn d-grid btn-danger text-white">Delete</button></td>
                      </tr>
                      <tr>
                        <td>5</td>
                        <td>Joshi</td>
                        <td>Hickle</td>
                        <td>@Maruti</td>
                        <td>member</td>
                        <td><button class="btn d-grid btn-info text-white">Details</button></td>
                        <td><button class="btn d-grid btn-warning text-white">Edit</button></td>
                        <td><button class="btn d-grid btn-danger text-white">Delete</button></td>
                      </tr>
                      <tr>
                        <td>6</td>
                        <td>Nigam</td>
                        <td>Eichmann</td>
                        <td>@Sonu</td>
                        <td>supporter</td>
                        <td><button class="btn d-grid btn-info text-white">Details</button></td>
                        <td><button class="btn d-grid btn-warning text-white">Edit</button></td>
                        <td><button class="btn d-grid btn-danger text-white">Delete</button></td>
                      </tr>
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
  </body>
</html>
