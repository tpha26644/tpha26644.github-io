<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!--[if IE 9]> <html class="no-js ie9 fixed-layout" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js " lang="en"> <!--<![endif]-->
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <head>

        <!-- Basic -->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
        <link rel="stylesheet" href="css/prettyPhoto.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/style.css">
        <link href="css/style_2.css" rel="stylesheet" type="text/css"/>

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
                



            <section class="section cb">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="tagline-message page-title">
                                <h3>Chương: ${ch.getChapterName()}</h3>
                            </div>
                        </div><!-- end col -->      
                    </div><!-- end row -->
                </div><!-- end container -->
            </section><!-- end section -->

            <section class="section">
                <div class="container">
                    <div class=" ">
                        <div class="row">
                            <div class="col-md-6 shop-media">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="image-wrap entry">
                                            <iframe width="500" height="500" src="https://www.youtube.com/embed/${l.getVideo()}"></iframe>
                                        </div><!-- end image-wrap -->
                                    </div>
                                </div><!-- end row -->

                                <hr class="invis">


                            </div><!-- end col -->

                            <div class="col-md-6">
                                <div class="shop-desc">
                                    <h3>Bài giảng: ${l.getTitle()}</h3>
                                </div><!-- end desc -->
                            </div><!-- end col -->
                        </div><!-- end row -->

                        <hr class="invis">

                        <div class="row">   
                            <div class="col-md-12">
                                <div class="shop-extra">
                                    <ul class="nav nav-tabs">
                                        <li class="active"><a data-toggle="tab" href="#home">Description</a></li>
                                        <li><a data-toggle="tab" href="#menu1">Quiz</a></li>
                                        <li><a data-toggle="tab" href="#menu2">Reviews (2)</a></li>
                                    </ul>

                                    <div class="tab-content">
                                        <div id="home" class="tab-pane fade in active">
                                            <p>${l.getReading()}</p>
                                        </div>
                                        <div id="menu1" class="tab-pane fade">
                                            <ul class="">
                                                <c:forEach items="${quizList}" var="quiz" varStatus="loop">
                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/quiz-handle?quizID=${quiz.quizID}">
                                                            Quiz ${loop.count}
                                                        </a>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div><!-- end shop-extra -->
                                        <div id="menu2" class="tab-pane fade">
                                            <!--Rate_Comment Review_Comment-->
                                            <div id="tab3" class="tab-pane fade in">
                                                <div class="row">
                                                    <!-- Reviews -->
                                                    <div class="col-md-6">
                                                        <div id="reviews">
                                                            <ul class="reviews">
                                                                <c:forEach items="${listCmt}" var="cmt">
                                                                    <li>
                                                                        <div class="review-heading">
                                                                            <h5 class="name">${cmt.nameLearner}</h5>
                                                                            <p class="date">${cmt.comment.timeComment}</p>
                                                                        </div>
                                                                        <div class="review-body">
                                                                            <p>${cmt.comment.content}</p>
                                                                        </div> 
                                                                    </li>
                                                                </c:forEach>
                                                            </ul>
                                                            <ul class="reviews-pagination">
                                                                <c:forEach begin="1" end="${totalPage}" var="i">
                                                                    <li><a href="LessonDetailController?index=${i}&lessonId=${lessonId}&chapterId=${chapterId}">${i}</a></li>
                                                                    </c:forEach>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <!-- /Reviews -->

                                                    <!-- Review Form -->
                                                    <div class="col-md-3">
                                                        <div id="review-form">
                                                            <form class="review-form" action="LessonDetailController?lessonId=${lessonId}&chapterId=${chapterId}" method="POST">
                                                                <textarea class="input" placeholder="Your Review" name="comment"></textarea>
                                                                <div class="input-rating">
                                                                    <span>Your Rating: </span>
                                                                    <div class="stars">
                                                                        <c:forEach begin="1" end="5" var="i">
                                                                            <c:choose>
                                                                                <c:when test="${i == (6 - rate)}">
                                                                                    <input class="fa fa-star" id="star${6-i}" name="rating" value="${6-i}" type="radio" checked><label for="star${6-i}"></label>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <input class="fa fa-star-o" id="star${6-i}" name="rating" value="${6-i}" type="radio"><label for="star${6-i}"></label>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:forEach>
                                                                    </div>
                                                                </div>
                                                                <button type="sumbit" class="primary-btn">Comment</button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                    <!-- /Review Form -->
                                                </div>
                                            </div>


                                        </div><!-- end shop-extra -->
                                    </div><!-- end col -->
                                </div><!-- end row -->

                                <hr class="invis">

                                <div class="related-products">
                                    <div class="text-widget">
                                        <h3>Another Course</h3>
                                    </div><!-- end title -->        

                                    <div class="row blog-grid shop-grid">
                                        <c:forEach items="${listC}" var="course">
                                            <div class="col-md-3">
                                                <div class="course-box shop-wrapper">
                                                    <div class="image-wrap entry">
                                                        <img style="height: 200px" src="images/courses/${course.getImage()}" alt="" class="img-responsive">
                                                        <div class="magnifier">
                                                            <a href="EnrollController?courseId=${course.getCourseID()}" title=""><i class="flaticon-add"></i></a>
                                                        </div>
                                                    </div>
                                                    <!-- end image-wrap -->
                                                    <div style="height: 125px" class="course-details shop-box text-center">
                                                        <h4>
                                                            <a href="EnrollController?courseId=${course.getCourseID()}" title="">${course.getCourseName()}</a>
                                                        </h4>

                                                    </div>
                                                    <!-- end details -->
                                                    <div class="course-footer clearfix">
                                                    </div><!-- end footer -->
                                                </div><!-- end box -->
                                            </div><!-- end col -->
                                        </c:forEach>
                                    </div><!-- end row -->
                                </div><!-- end related -->
                            </div><!-- end boxed -->
                        </div><!-- end container -->
                        </section>


                        <footer class="section footer noover">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-4 col-md-4">
                                        <div class="widget clearfix">
                                            <h3 class="widget-title">Subscribe Our Newsletter</h3>
                                            <div class="newsletter-widget">
                                                <p>You can opt out of our newsletters at any time.<br> See our <a href="#">privacy policy</a>.</p>
                                                <form class="form-inline" role="search">
                                                    <div class="form-1">
                                                        <input type="text" class="form-control" placeholder="Enter email here..">
                                                        <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane-o"></i></button>
                                                    </div>
                                                </form>
                                                <img src="images/payments.png" alt="" class="img-responsive">
                                            </div><!-- end newsletter -->
                                        </div><!-- end widget -->
                                    </div><!-- end col -->


                                    <div class="col-lg-3 col-md-3">
                                        <div class="widget clearfix">
                                            <h3 class="widget-title">Join us today</h3>
                                            <p>Would you like to earn your profits by joining our team? Join us without losing time.</p>
                                            <a href="#" class="readmore">Became a Teacher</a>
                                        </div><!-- end widget -->
                                    </div><!-- end col -->

                                    <div class="col-lg-3 col-md-3">
                                        <div class="widget clearfix">
                                            <h3 class="widget-title">Popular Tags</h3>
                                            <div class="tags-widget">   
                                                <ul class="list-inline">
                                                    <li><a href="#">course</a></li>
                                                    <li><a href="#">web design</a></li>
                                                    <li><a href="#">development</a></li>
                                                    <li><a href="#">language</a></li>
                                                    <li><a href="#">teacher</a></li>
                                                    <li><a href="#">speaking</a></li>
                                                    <li><a href="#">material</a></li>
                                                    <li><a href="#">css3</a></li>
                                                    <li><a href="#">html</a></li>
                                                    <li><a href="#">learning</a></li>
                                                </ul>
                                            </div><!-- end list-widget -->
                                        </div><!-- end widget -->
                                    </div><!-- end col -->

                                    <div class="col-lg-2 col-md-2">
                                        <div class="widget clearfix">
                                            <h3 class="widget-title">Support</h3>
                                            <div class="list-widget">   
                                                <ul>
                                                    <li><a href="#">Terms of Use</a></li>
                                                    <li><a href="#">Copyrights</a></li>
                                                    <li><a href="#">Create a Ticket</a></li>
                                                    <li><a href="#">Pricing & Plans</a></li>
                                                    <li><a href="#">Carrier</a></li>
                                                    <li><a href="#">Trademark</a></li>
                                                </ul>
                                            </div><!-- end list-widget -->
                                        </div><!-- end widget -->
                                    </div><!-- end col -->
                                </div><!-- end row -->
                            </div><!-- end container -->
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
                    <script src="js/animate.js"></script>
                    <script src="js/jquery.prettyPhoto.js"></script>
                    <script src="js/custom.js"></script>
                    </body>
                    </html>