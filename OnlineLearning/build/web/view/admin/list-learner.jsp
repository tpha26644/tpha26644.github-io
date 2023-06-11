<%-- 
    Document   : basic-table
    Created on : 27-Feb-2022, 21:50:50
    Author     : NHATNAM-PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.LearnerAndAccount"%>
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
              <h4 class="page-title">List Learner</h4>
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
                <!--<h3 class="box-title">List Learner</h3>-->
                <button type="button" class="btn btn-success text-white" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">Add Learner</button>
                <span class=""><code>${err}</code></span>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">

                      <form action="list-learner?action=addLearnerByAdmin" method="POST">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel">ADD LEARNER</h5>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                          <div class="mb-3">
                            <label for="name" class="col-form-label">Name:</label>
                            <input type="text" class="form-control" name="name" value="${name}">
                          </div>
                          <div class="mb-3">
                            <label for="username" class="col-form-label">Username:</label>
                            <input type="text" class="form-control" name="username" value="${username}">
                          </div>
                          <div class="mb-3">
                            <label for="password" class="col-form-label">Password:</label>
                            <input type="password" class="form-control" name="password" value="${password}">
                          </div>
                          <div class="mb-3">
                            <label for="repassword" class="col-form-label">Re-Password:</label>
                            <input type="password" class="form-control" name="rePassword" value="${rePassword}">
                          </div>
                          <div class="mb-3">
                            <label for="email" class="col-form-label">Email:</label>
                            <input type="email" class="form-control" name="email" value="${email}">
                          </div>
                          <div class="mb-3">
                            <label for="phone" class="col-form-label">Phone:</label>
                            <input type="text" class="form-control" name="phone" value="${phone}">
                          </div>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-secondary text-white" data-bs-dismiss="modal">Close</button>
                          <input type="submit" class="btn btn-success text-white" name="add" value="Add">
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
                <!--<p class="text-muted">Add class <code>.table</code></p>-->
                <div class="table-responsive">
                  <table class="table text-nowrap">
                    <thead>
                      <tr>
                        <!--<th class="border-top-0">#</th>-->
                        <th class="border-top-0">Learner ID</th>
                        <th class="border-top-0">Username</th>
                        <th class="border-top-0">Fullname</th>
                        <th class="border-top-0">Email</th>
                        <th class="border-top-0">Phone</th>
                        <th class="border-top-0">Details</th>
                        <th class="border-top-0">Status</th>
                      </tr>
                    </thead>
                    <tbody>

                      <c:forEach items="${listLearner}" var="i" varStatus="loop">

                          <tr>
                            <!--<td>${loop.count}</td>-->
                            <td>${i.getLearnerID()}</td>
                            <td>${i.getUsername()}</td>
                            <td>${i.getFullname()}</td>
                            <td>${i.getEmail()}</td>
                            <td>${i.getPhone()}</td>
                            <td><a class="btn btn-info text-white" 
                                   href="${pageContext.request.contextPath}/admin/learner-profile?learnerID=${i.getLearnerID()}">
                                Details</a></td>
                            <td>
                              <c:choose>
                                  <c:when test="${i.isStatus()}">
                                      <a href="${pageContext.request.contextPath}/admin/list-learner?action=changeStatus&learnerID=${i.getLearnerID()}&status=0"
                                         class='btn btn-danger text-white'>Active</a>
                                  </c:when>    
                                  <c:otherwise>
                                      <a href="${pageContext.request.contextPath}/admin/list-learner?action=changeStatus&learnerID=${i.getLearnerID()}&status=1"
                                         class='btn btn-warning text-white'>Deactive</a>
                                  </c:otherwise>
                              </c:choose>
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
