<%-- 
    Document   : course-details
    Created on : Feb 22, 2022, 4:36:52 AM
    Author     : Linh
--%>

<%@page import="dao.EnrollDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon" />
        <link rel="apple-touch-icon" href="../images/apple-touch-icon.png">

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>course-detail</title>
        <link rel="stylesheet" href="../css/course/course-details.css">
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            /* Stackoverflow preview fix, please ignore */
            .navbar-nav {
                flex-direction: row;
            }

            .nav-link {
                padding-right: .5rem !important;
                padding-left: .5rem !important;
            }

            /* Fixes dropdown menus placed on the right side */
            .ml-auto .dropdown-menu {
                left: auto !important;
                right: 0px;
            }
        </style>
    </head>
    <body>
        <!-- LOADER -->
        <div id="preloader">
            <img class="preloader" src="images/loader.gif" alt="">
        </div><!-- end loader -->
        <!-- END LOADER -->

        <div id="wrapper">
            <!-- BEGIN # MODAL LOGIN -->
            <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Begin # DIV Form -->
                        <div id="div-forms">
                            <form id="login-form">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span class="flaticon-add" aria-hidden="true"></span>
                                </button>
                                <div class="modal-body">
                                    <input class="form-control" type="text" placeholder="What you are looking for?" required>
                                </div>
                            </form><!-- End # Login Form -->
                        </div><!-- End # DIV Form -->
                    </div>
                </div>
            </div>
            <!-- END # MODAL LOGIN -->

            <header class="header header-normal" style="background-color: #000" >
                <jsp:include page="../html/header.jsp"></jsp:include>
                </header>
                <style>
                    .container .navbar-default {
                        display: block;
                    }
                </style>
                <div class="container-fluid mt-5">
                    <div style="background-color: #f3f3f6;">
                        <div class="row" >
                            <div class="col-md-6" style="padding: 10px 20px;">
                                <div class="carousel slide" data-ride="carousel" id="carousel-1">
                                    <div class="carousel-inner" role="listbox">
                                        <div class="carousel-item active"><img class="img-thumbnail w-100 d-block" src="images/courses/${c.getImage()}" alt="Slide Image" loading="lazy"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6" style="padding: 10px 20px;">
                            <h4 style="font-weight: bold;">${c.getCourseName()}</h4>
                            <div class="d-flex align-items-center mt-4 offers mb-1"><i class="fa fa-check-square-o mt-1"></i><span class="ml-1">${c.getOverview()}<br></span></div>
                            <div class="d-flex align-items-center mt-5 delivery"><i class="fa fa-map-marker"></i><span class="ml-2">Create date: ${c.getCreateDate()}<br></span><span class="ml-2 mr-2">|<br></span><span class="ml-2 mr-2 text-success">Author: ${c.getAuthor().getFullname()}<br></span></div>
                            <hr>
                            <form action="EnrollController">
                                <div class="mt-3">
                                    <input type="hidden" name="courseId" value="${c.getCourseID()}">
                                    <input class="btn btn-dark mr-2" type="submit" name="submit" value="Enroll me for this course">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <div class="col-md-12 mt20">
                    <h3 class="course-details--section-title">Thông tin chi tiết của khóa học</h3>
                    <hr>
                    <div class="RenderedMarkdown">
                        <p>${c.getDescription()}</p>
                        <p><strong>Khóa học thuộc: </strong>${c.getCategory().getCategoryName()}</p>
                        <p><strong>Tác giả: </strong>${c.getAuthor().getFullname()}</p>
                    </div>
                    <h3 class="course-details--section-title">Tóm tắt về khóa học</h3>
                    <hr>
                    <div class="mt20 mb10">
                    </div>
                    <ul class="list-unstyled" lang="vi">
                        <li>
                            <h6 style="text-decoration: underline;">Lộ trình của khóa học (Gồm ${total_chapter} chương và ${total_lesson} bài giảng)</h6>
                            <c:forEach items="${list_chapter}" var="chapter" varStatus="status">
                                <p>Chương ${status.count}: ${chapter.getChapterName()}</p>

                            </c:forEach>

                        </li>
                        <li>
                            <h6 style="text-decoration: underline;">Tổng số bài kiểm tra: ${total_quiz}</h6>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- jQuery Files -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/animate.js"></script>
        <script src="js/bootstrap-select.min.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>
