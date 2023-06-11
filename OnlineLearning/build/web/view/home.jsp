<%-- 
    Document   : home
    Created on : Feb 25, 2022, 5:30:40 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <link rel="stylesheet" href="css/carousel.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/style_1.css">
        <link href="css/tect.css" rel="stylesheet" type="text/css"/>

        <!--[if lt IE 9]>
                <script src="js/vendor/html5shiv.min.js"></script>
                <script src="js/vendor/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>  
        <%
            ArrayList<Course> listC = (ArrayList) request.getAttribute("listC");
        %>
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

            <header class="header">
                <jsp:include page="html/header.jsp"></jsp:include>
            </header>
                

            <section id="home" class="video-section js-height-full">
                <div class="overlay"></div>
                <div class="home-text-wrapper relative container">
                    <div class="home-message">
                        <p>Learning Management System</p>
                        <small>Edulogy is the ideal choice for your organization, your business and your online education system. Create your online course now with unlimited page templates, color options, and menu features.</small>
                        <div class="btn-wrapper">
                            <div class="text-center">
                                <a href="#" class="btn btn-primary wow slideInLeft">Read More</a> &nbsp;&nbsp;&nbsp;<a href="#" class="btn btn-default wow slideInRight">Buy Now</a>
                            </div>
                        </div><!-- end row -->
                    </div>
                </div>
                <div class="slider-bottom">
                    <span>Explore <i class="fa fa-angle-down"></i></span>
                </div>
            </section>

            <section class="section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 hidden-sm hidden-xs">
                            <div class="custom-module">                          
                                <img src="images/wallpaper360x640.jpg" class="img-responsive wow slideInLeft" alt=""/>
                            </div><!-- end module -->
                        </div><!-- end col -->
                        <div class="col-md-8">
                            <div class="custom-module p40l">
                                <h2>We are a passionate <mark>learning system</mark> from<br>
                                    Vietnam. Learn and practice to get rid of covid-19 <br>
                                    quickly</h2>

                                <p>We provide all lessons on all the symptoms experienced by patients to be able to serve the maximum number of patients.</p>

                                <hr class="invis">

                                <div class="row">
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 first">
                                        <ul class="check">
                                            <li>Fever</li>
                                            <li>Cough</li>
                                            <li>Tired</li>
                                            <li>Loss of taste or smell</li>
                                            <li>Sore throat</li>
                                        </ul><!-- end check -->
                                    </div><!-- end col-lg-4 -->
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                        <ul class="check">
                                            <li>Headache</li>
                                            <li>Hurt</li>
                                            <li>Diarrhea</li>
                                            <li>Skin rash</li>
                                            <li>Red fingers and toes</li>
                                        </ul><!-- end check -->    
                                    </div><!-- end col-lg-4 -->
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 last">
                                        <ul class="check">
                                            <li>Red or itchy eyes</li>
                                            <li>Shortness of breath</li>
                                            <li>Confusion</li>
                                            <li>Inability to speak or move</li>
                                            <li>Chest pain</li>
                                        </ul><!-- end check -->
                                    </div><!-- end col-lg-4 --> 
                                </div><!-- end row -->   

                                <hr class="invis">

                                <div class="btn-wrapper">
                                    <a href="#" class="btn btn-primary">Learn More About us</a>
                                </div>

                            </div><!-- end module -->
                        </div><!-- end col -->
                    </div><!-- end row -->
                </div><!-- end container -->
            </section>

            <section class="section gb">
                <div class="container">
                    <div class="section-title text-center">
                        <h3>Recent Courses</h3>
                        <p>Maecenas sit amet tristique turpis. Quisque porttitor eros quis leo pulvinar, at hendrerit sapien iaculis. Donec consectetur accumsan arcu, sit amet fringilla ex ultricies.</p>
                    </div><!-- end title -->

                    <div id="owl-01" class="owl-carousel owl-theme owl-theme-01">
                        <c:forEach items="${listC}" var="course">
                            <div class="caro-item">
                                <div class="course-box">
                                    <div class="image-wrap entry">
                                        <img style="height: 200px" src="images/courses/${course.getImage()}" alt="" class="img-responsive">
                                        <div class="magnifier">
                                            <a href="course/course-detail?courseId=${course.getCourseID()}" title=""><i class="flaticon-add"></i></a>
                                        </div>
                                    </div><!-- end image-wrap -->
                                    <div class="course-details">
                                        <h4 style="height: 100px">
                                            <small></small>
                                            <a href="course/course-detail?courseId=${course.getCourseID()}" title="">${course.getCourseName()}</a>
                                        </h4>
                                        <p class="overview" style="height: 185px">${course.getOverview()}</p>
                                    </div><!-- end details -->
                                    <div class="course-footer clearfix">
                                        <div class="pull-left">
                                            <ul class="list-inline">
                                                <li><a href="#"><i class="fa fa-user"></i> 21</a></li>
                                                <li><a href="#"><i class="fa fa-clock-o"></i> 15 Min.</a></li>
                                            </ul>
                                        </div><!-- end left -->
                                    </div><!-- end footer -->
                                </div><!-- end box -->
                            </div><!-- end col -->
                        </c:forEach>
                    </div><!-- end row -->

                    <hr class="invis">

                    <div class="section-button text-center">
                        <a href="list-course" class="btn btn-primary">View All Courses</a>
                    </div>
                </div><!-- end container -->
            </section>

            <footer class="section footer noover">
            <jsp:include page="html/footer.jsp"></jsp:include>
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
                                    <li>Design : <a href="https://html.design">HTML.Design</a></li>
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
        <script src="js/carousel.js"></script>
        <script src="js/animate.js"></script>
        <script src="js/custom.js"></script>
        <!-- VIDEO BG PLUGINS -->
        <script src="js/videobg.js"></script>

    </body>
</html>
