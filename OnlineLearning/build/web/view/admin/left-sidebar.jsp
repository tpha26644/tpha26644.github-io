<%-- 
    Document   : left-sidebar
    Created on : 27-Feb-2022, 23:59:05
    Author     : NHATNAM-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <aside class="left-sidebar" data-sidebarbg="skin6">
      <!-- Sidebar scroll-->
      <div class="scroll-sidebar">
        <!-- Sidebar navigation-->
        <nav class="sidebar-nav">
          <ul id="sidebarnav">
            <!-- User Profile-->
            <li class="sidebar-item pt-2">
              <a class="sidebar-link waves-effect waves-dark sidebar-link" href="${pageContext.request.contextPath}/admin/dashboard"
                 aria-expanded="false">
                <i class="far fa-clock" aria-hidden="true"></i>
                <span class="hide-menu">Dashboard</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link waves-effect waves-dark sidebar-link" href="${pageContext.request.contextPath}/admin/profile"
                 aria-expanded="false">
                <i class="fa fa-user" aria-hidden="true"></i>
                <span class="hide-menu">Profile</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link waves-effect waves-dark sidebar-link" href="${pageContext.request.contextPath}/admin/list-learner"
                 aria-expanded="false">
                <i class="fa fa-table" aria-hidden="true"></i>
                <span class="hide-menu">List Learner</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link waves-effect waves-dark sidebar-link" href="${pageContext.request.contextPath}/admin/list-lecture"
                 aria-expanded="false">
                <i class="fa fa-table" aria-hidden="true"></i>
                <span class="hide-menu">List Lecture</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link waves-effect waves-dark sidebar-link" href="${pageContext.request.contextPath}/admin/basic-table"
                 aria-expanded="false">
                <i class="fa fa-table" aria-hidden="true"></i>
                <span class="hide-menu">Basic Table</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link waves-effect waves-dark sidebar-link" href="#"
                 aria-expanded="false">
                <i class="fa fa-font" aria-hidden="true"></i>
                <span class="hide-menu">Course</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link waves-effect waves-dark sidebar-link" href="map-google.jsp"
                 aria-expanded="false">
                <i class="fa fa-globe" aria-hidden="true"></i>
                <span class="hide-menu">Google Map</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link waves-effect waves-dark sidebar-link" href="blank.jsp"
                 aria-expanded="false">
                <i class="fa fa-columns" aria-hidden="true"></i>
                <span class="hide-menu">Blank Page</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link waves-effect waves-dark sidebar-link" href="404.jsp"
                 aria-expanded="false">
                <i class="fa fa-info-circle" aria-hidden="true"></i>
                <span class="hide-menu">Error 404</span>
              </a>
            </li>
            <li class="text-center p-20 upgrade-btn">
              <a href="https://www.wrappixel.com/templates/ampleadmin/"
                 class="btn d-grid btn-danger text-white" target="_blank">
                Upgrade to Pro</a>
            </li>
          </ul>

        </nav>
        <!-- End Sidebar navigation -->
      </div>
      <!-- End Sidebar scroll-->
    </aside>
  </body>
</html>
