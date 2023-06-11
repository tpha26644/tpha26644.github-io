<%-- 
    Document   : list
    Created on : Feb 27, 2022, 10:45:33 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<!--[if IE 9]> <html class="no-js ie9 fixed-layout" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> 
<html class="no-js " lang="en"> <!--<![endif]-->
    <head>

        <!-- Basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Meta -->
        <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

        <!-- Site Meta -->
        <title>Edulogy</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,700,900" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,400i,700,700i" rel="stylesheet"> 

        <!-- Custom & Default Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap-select.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/style.css">
        <!--<link href="css/dropdown.css" rel="stylesheet" type="text/css"/>-->
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

        <!--[if lt IE 9]>
            <script src="js/vendor/html5shiv.min.js"></script>
            <script src="js/vendor/respond.min.js"></script>
        <![endif]-->

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

                <section class="section lb p120">
                    <div class="container">
                        <img src="images/courses/header_main.jpg" style="max-width: 100%;"/>

                    </div><!-- end container -->
                </section><!-- end section -->
            <c:if test="${account!=null}">
                <%@include file="suggest-course.jsp" %>
            </c:if>
            <section class="section gb nopadtop">
                <div class="container">
                    <div class="boxed boxedp4">
                        <div class="shop-top">
                            <div class="clearfix">
                                <div class="pull-left">
                                    <p> Showing 1–20 of ${listCourses.size()} results</p>
                                </div>
                            </div>
                        </div>

                        <div class="row mb-3 blog-grid shop-grid w-100">
                            <!blog-grid shop-grid!>
                            <c:if test="${listCourses==null ||listCourses.size()==0}">
                                <div class="alert alert-warning" role="alert">
                                    <h3>Không tìm thấy sản phẩm tương tự!</h3>
                                </div>
                            </c:if>

                            <c:forEach items="${listCourses}" var="course">                                
                                <div class="col-md-4" style="height: 28em">
                                    <div class="course-box shop-wrapper" style="border-radius: 5px">
                                        <div class="image-wrap entry">
                                            <img style="max-width: 100%; max-height: 100%; height: 260px" src="images/courses/${course.getImage()}" alt="" class="img-responsive">
                                            <div class="magnifier">
                                                <c:if test="${sessionScope.account != null}">
                                                    <a href="EnrollController?courseId=${course.getCourseID()}" title=""><i class='fas fa-book-medical'></i></a>
                                                    </c:if>
                                                    <c:if test="${sessionScope.account == null}">
                                                    <a href="login" title=""><i class='fas fa-book-medical'></i></a>
                                                    </c:if>
                                            </div>
                                        </div>
                                        <!-- end image-wrap -->
                                        <div class="course-details shop-box text-center" style="height: 141px;">
                                            <h4>
                                                <c:if test="${sessionScope.account != null}">
                                                    <a href="EnrollController?courseId=${course.getCourseID()}" title="">${course.getCourseName()}</a>
                                                </c:if>
                                                <c:if test="${sessionScope.account == null}">
                                                    <a href="login" title="">${course.getCourseName()}</a>
                                                </c:if>
                                                <small>${course.getCategory().getCategoryName()}</small>
                                            </h4>
                                        </div>
                                        <!-- end details -->
                                        <div class="course-footer clearfix">
                                            <div class="pull-left">
                                                <ul class="list-inline">
                                                    <li><a href="EnrollController?courseId=${course.getCourseID()}"><i class="fas fa-atlas"></i>Learn Now!</a></li>
                                                </ul>
                                            </div><!-- end left -->

                                            <div class="pull-right">
                                                <ul class="list-inline">
                                                    <li><a href="#">${course.getAuthor().getFullname()}</a></li>
                                                </ul>
                                            </div><!-- end left -->
                                        </div><!-- end footer -->
                                    </div><!-- end box -->
                                </div><!-- end col -->       
                            </c:forEach>

                        </div><!-- end row -->

                        <hr class="invis">

                        <!--paging-->
                        <div class="row text-center">
                            <div class="col-md-12">
                                <c:if test="${totalPage>1}">
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination justify-content-end">
                                            <li class="page-item ${page <= 1?"disabled":""}">
                                                <a class="page-link" href="list-course?page=${page-1}" tabindex="-1" aria-disabled="true"><<</a>
                                            </li>
                                            <c:forEach begin="1" end="${totalPage}" var="i">
                                                <li class="page-item ${i == page?"active":""}"><a class="page-link" href="list-course?page=${i}">${i}</a></li>
                                                </c:forEach>

                                            <li class="page-item ${page >= totalPage?"disabled":""}">
                                                <a class=" page-link" href="list-course?page=${page+1}">>></a>
                                            </li>
                                        </ul>
                                    </nav>
                                </c:if>
                            </div>
                        </div>


                    </div>
                </div><!-- end container -->
            </section>

            <footer class="section footer noover">
                <jsp:include page="../html/footer.jsp"></jsp:include>
            </footer><!-- end footer -->

            <div class="copyrights">
                <div class="container">
                    <div class="clearfix">
                        <div class="pull-left">
                            <div class="cop-logo">
                                <a href="#"><img src="images/logo.png" alt=""></a>
                            </div>
                        </div>

                        <div class="pull-right">
                            <div class="footer-links">
                                <ul class="list-inline">
                                    <li>Author : <a href="https://www.facebook.com/phucuong.tran.589/">Tran Phu Cuong</a></li>
                                    <li>Distributed by : <a href="https://themewagon.com/" target="_blank">ThemeWagon</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div><!-- end container -->
            </div><!-- end copy -->
        </div><!-- end wrapper -->

        <!-- jQuery Files -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/animate.js"></script>
        <script src="js/bootstrap-select.min.js"></script>
        <script src="js/custom.js"></script>

    </body>
</html>
