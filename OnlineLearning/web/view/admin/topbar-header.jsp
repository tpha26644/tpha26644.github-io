<%-- 
    Document   : topbar-header
    Created on : 27-Feb-2022, 23:57:54
    Author     : NHATNAM-PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="entity.Admin"%>
<%@page import="dao.AdminDAO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="entity.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <header class="topbar" data-navbarbg="skin5">
      <nav class="navbar top-navbar navbar-expand-md navbar-dark">
        <div class="navbar-header" data-logobg="skin6">
          <!-- ============================================================== -->
          <!-- Logo -->
          <!-- ============================================================== -->
          <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/dashboard">
            <!-- Logo icon -->
            <b class="logo-icon">
              <!-- Dark Logo icon -->
              <img src="${pageContext.request.contextPath}/view/admin/plugins/images/logo-icon.png" alt="homepage" />
            </b>
            <!--End Logo icon -->
            <!-- Logo text -->
            <span class="logo-text">
              <!-- dark Logo text -->
              <img src="${pageContext.request.contextPath}/view/admin/plugins/images/logo-text.png" alt="homepage" />
            </span>
          </a>
          <!-- ============================================================== -->
          <!-- End Logo -->
          <!-- ============================================================== -->
          <!-- ============================================================== -->
          <!-- toggle and nav items -->
          <!-- ============================================================== -->
          <a class="nav-toggler waves-effect waves-light text-dark d-block d-md-none"
             href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
        </div>
        <!-- ============================================================== -->
        <!-- End Logo -->
        <!-- ============================================================== -->
        <div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">

          <!-- ============================================================== -->
          <!-- Right side toggle and nav items -->
          <!-- ============================================================== -->
          <ul class="navbar-nav ms-auto d-flex align-items-center">

            <!-- ============================================================== -->
            <!-- Search -->
            <!-- ============================================================== -->
            <li class=" in">
              <form role="search" class="app-search d-none d-md-block me-3">
                <input type="text" placeholder="Search..." class="form-control mt-0">
                <a href="" class="active">
                  <i class="fa fa-search"></i>
                </a>
              </form>
            </li>
            <!-- ============================================================== -->
            <!-- User profile and search -->
            <!-- ============================================================== -->
            
            <li>
              <a class="profile-pic" href="${pageContext.request.contextPath}/admin/profile">
                <img src="${pageContext.request.contextPath}/view/admin/plugins/images/users/varun.jpg" alt="user-img" width="36"
                     class="img-circle">
                <span class="text-white font-medium">${admin.getFullname()}</span>
              </a>
            </li>
            <!-- ============================================================== -->
            <!-- User profile and search -->
            <!-- ============================================================== -->
            <li>
              <a class="profile-pic" href="${pageContext.request.contextPath}/LogoutController">
                <span class="text-white font-medium">Log out</span></a>
            </li>
          </ul>
        </div>
      </nav>
    </header>
  </body>
</html>
