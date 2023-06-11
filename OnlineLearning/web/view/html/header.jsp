<%-- 
    Document   : header
    Created on : Feb 28, 2022, 7:40:45 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <!--[if lt IE 9]>
                <script src="js/vendor/html5shiv.min.js"></script>
                <script src="js/vendor/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <div class="topbar clearfix">
            <div class="container">
                <div class="row-fluid">
                    <div class="col-md-6 col-sm-6 text-left">
                        <p>
                            <strong><i class="fa fa-phone"></i></strong> 0913096351 &nbsp;&nbsp;
                            <strong><i class="fa fa-envelope"></i></strong> <a href="https://mail.google.com/mail/u/0/#inbox">hoangckthao33@gmail.com</a>                                
                        </p>
                    </div><!-- end left -->
                    <div class="col-md-6 col-sm-6 hidden-xs text-right">
                        <div class="social">
                            <a class="facebook" href="https://www.facebook.com/duongdinhhoang2k" data-tooltip="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook"></i></a>              
                            <a class="twitter" href="#" data-tooltip="tooltip" data-placement="bottom" title="Twitter"><i class="fa fa-twitter"></i></a>
                            <a class="google" href="#" data-tooltip="tooltip" data-placement="bottom" title="Google Plus"><i class="fa fa-google-plus"></i></a>
                            <a class="linkedin" href="#" data-tooltip="tooltip" data-placement="bottom" title="Linkedin"><i class="fa fa-linkedin"></i></a>
                            <a class="pinterest" href="#" data-tooltip="tooltip" data-placement="bottom" title="Pinterest"><i class="fa fa-pinterest"></i></a>
                        </div><!-- end social -->
                    </div><!-- end left -->
                </div><!-- end row -->
            </div><!-- end container -->
        </div><!-- end topbar -->

        <div class="container">
            <nav class="navbar navbar-default yamm">
                 <!--style="display:block;"-->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="logo-normal">
                        <a class="navbar-brand" href="HomeController"><img src="images/logo.png" alt=""></a>
                    </div>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="HomeController">Home</a></li>
                        <li><a href="list-course">List Course</a></li>
                        <li><a href="list-lecture">List Lecture</a></li>                     
                            <c:if test="${sessionScope.account == null}">
                            <li><a href="login">Login</a></li>
                            </c:if>
                            <c:if test="${sessionScope.account != null}">
                            <li><a href="LogoutController">Logout</a></li>
                            </c:if>
                        <li class="iconitem"><a class="shopicon" href="${pageContext.request.contextPath}/learner/learner-profile"><i class="fa fa-user"></i></a></li>
                    </ul>
                </div>
            </nav><!-- end navbar -->
        </div><!-- end container -->
    </body>

    
</html>
