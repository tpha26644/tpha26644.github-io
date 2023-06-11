<%-- 
    Document   : addLecture
    Created on : Mar 9, 2022, 3:23:55 PM
    Author     : asus
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
        <title>List Lecture</title>
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
        <div class="preloader">
            <div class="lds-ripple">
                <div class="lds-pos"></div>
                <div class="lds-pos"></div>
            </div>
        </div>
        <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
             data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">

            <%@include file="topbar-header.jsp" %>
            <%@include file="left-sidebar.jsp" %>

            <div class="page-wrapper">
                <div class="page-breadcrumb bg-white">
                    <div class="row align-items-center">
                        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                            <h4 class="page-title">List Lecture</h4>
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
                </div>
                <div class="container-fluid">
                    <form action="../admin/addLecture" method="POST">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">ADD LECTURE</h5>
                            <h3>${registerFailed}</h3>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="name" class="col-form-label">Name:</label>
                                <input type="text" class="form-control" name="name">
                            </div>
                            <div class="mb-3">
                                <label for="username" class="col-form-label">Username:</label>
                                <input type="text" class="form-control" name="username" >
                            </div>
                            <div class="mb-3">
                                <label for="password" class="col-form-label">Password:</label>
                                <input type="password" class="form-control" name="password" >
                            </div>
                            <div class="mb-3">
                                <label for="email" class="col-form-label">Email:</label>
                                <input type="email" class="form-control" name="email" >
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="col-form-label">Phone:</label>
                                <input type="text" class="form-control" name="phone" >
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary btn-block">Register</button>
                        </div>
                    </form>
                </div>
                <footer class="footer text-center"> 2021 © Ample Admin brought to you by <a
                        href="https://www.wrappixel.com/">wrappixel.com</a>
                </footer>
            </div>
        </div>

        <script>

        </script>

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
