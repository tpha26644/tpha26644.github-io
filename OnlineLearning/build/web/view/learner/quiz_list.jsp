<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<!--[if IE 9]> <html class="no-js ie9 fixed-layout" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js " lang="en"> <!--<![endif]-->
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

            <header class="header header-normal" style="background-color: #000">
                <jsp:include page="../html/header.jsp"></jsp:include>
                </header>

                <section class="parallax event-section" data-stellar-background-ratio="0.5" style="background-image:url('images/rengoku1920.jpg');">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="tagline-message event-title text-center" style="background-color: #000000; opacity: 0.6">
                                    <h3 style="color: #FFF8DC">Edulogy - Where great teachers gather</h3>
                                    <p style="color: #FFF8DC">With nearly 50 instructors everywhere also with a huge amount of knowledge</p>
                                    <a href="login" class="btn btn-primary">LEARN NOW</a>
                                </div>
                            </div><!-- end col -->
                        </div><!-- end row -->
                    </div><!-- end container -->
                </section><!-- end section -->

                
                <section class="section gb nopadtop">

                    <div class="container">
                        <div class="col-md-12">
                            <div class="row mb-3 event-boxes">
                            <c:forEach items="${listQuizzes}" var="quiz">
                                <div class="col-md-4 mb-10" style="height: 350px">
                                    <div class="box m30">                                                 
                                        <div class="event-desc">
                                            <small>Quiz Number ${quiz.getQuizID()}. Lesson: </small> <h4 inline>${quiz.getLesson().getTitle()}</h4>
                                            <p><a href="">Click here to view detail --></a></p>
                                        </div>
                                    </div>
                                </div><!-- end col -->
                            </c:forEach>  
                        </div><!-- end row -->
                    </div>

                   
                </div><!-- end container -->
            </section>




            <section class="section">
                <div class="container">
                    <div class="section-title text-center">
                        <h3>Meet Our Speakers</h3>
                        <p>Maecenas sit amet tristique turpis. Quisque porttitor eros quis leo pulvinar, at hendrerit sapien iaculis. Donec consectetur accumsan arcu, sit amet fringilla ex ultricies.</p>
                    </div><!-- end title -->

                    <div class="row text-center">
                        <div class="col-md-4 col-sm-6">
                            <div class="teammembers">
                                <div class="entry">
                                    <img src="upload/01_team.png" alt="" class="img-responsive">
                                    <div class="magnifier">
                                        <div class="visible-buttons1 teambuttons">
                                            <p>We?re committed to work and play our client meeting room transforms  into a table tennis</p>
                                            <div class="social-links">
                                                <a href="#"><i class="fa fa-facebook"></i></a>
                                                <a href="#"><i class="fa fa-dribbble"></i></a>
                                                <a href="#"><i class="fa fa-twitter"></i></a>
                                                <a href="#"><i class="fa fa-skype"></i></a>
                                            </div><!-- end social -->
                                        </div>
                                    </div>
                                </div><!-- end box -->
                                <div class="teamdesc">
                                    <h4>Ruben Franklin</h4>
                                    <p>Web Design Builder & Seo Specialist</p>
                                </div><!-- end teamdesc -->
                            </div><!-- end teammembers -->
                        </div><!-- end col -->

                        <div class="col-md-4 col-sm-6">
                            <div class="teammembers">
                                <div class="entry">
                                    <img src="upload/02_team.png" alt="" class="img-responsive">
                                    <div class="magnifier">
                                        <div class="visible-buttons1 teambuttons">
                                            <p>We?re committed to work and play our client meeting room transforms  into a table tennis</p>
                                            <div class="social-links">
                                                <a href="#"><i class="fa fa-facebook"></i></a>
                                                <a href="#"><i class="fa fa-dribbble"></i></a>
                                                <a href="#"><i class="fa fa-twitter"></i></a>
                                                <a href="#"><i class="fa fa-skype"></i></a>
                                            </div><!-- end social -->
                                        </div>
                                    </div>
                                </div><!-- end box -->
                                <div class="teamdesc">
                                    <h4>Martin Juhnson</h4>
                                    <p>Web Design Builder & Seo Specialist</p>
                                </div><!-- end teamdesc -->
                            </div><!-- end teammembers -->
                        </div><!-- end col -->

                        <div class="col-md-4 col-sm-6">
                            <div class="teammembers">
                                <div class="entry">
                                    <img src="upload/03_team.png" alt="" class="img-responsive">
                                    <div class="magnifier">
                                        <div class="visible-buttons1 teambuttons">
                                            <p>We?re committed to work and play our client meeting room transforms  into a table tennis</p>
                                            <div class="social-links">
                                                <a href="#"><i class="fa fa-facebook"></i></a>
                                                <a href="#"><i class="fa fa-dribbble"></i></a>
                                                <a href="#"><i class="fa fa-twitter"></i></a>
                                                <a href="#"><i class="fa fa-skype"></i></a>
                                            </div><!-- end social -->
                                        </div>
                                    </div>
                                </div><!-- end box -->
                                <div class="teamdesc">
                                    <h4>Bob Dylean</h4>
                                    <p>Web Design Builder & Seo Specialist</p>
                                </div><!-- end teamdesc -->
                            </div><!-- end teammembers -->
                        </div><!-- end col -->
                    </div><!-- end row -->
                </div><!-- end container -->
            </section>


            <section class="section bgcolor1">
                <div class="container">
                    <a href="#">
                        <div class="row callout">
                            <div class="col-md-4 text-center">
                                <h3><sup>$</sup>49.99</h3>
                                <h4>Start your awesome course today!</h4>
                            </div><!-- end col -->

                            <div class="col-md-8">
                                <p class="lead">Limited time offer! Your profile will be added to our "Students" directory as well. </p>
                            </div>
                        </div><!-- end row -->
                    </a>
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
        <script src="js/parallax.js"></script>
        <script src="js/animate.js"></script>
        <script src="js/custom.js"></script>
        <!-- VIDEO BG PLUGINS -->
        <script src="js/videobg.js"></script>

    </body>
</html>