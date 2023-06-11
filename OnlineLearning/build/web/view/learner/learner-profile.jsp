<%-- 
    Document   : learner-profile
    Created on : Feb 14, 2022, 11:53:32 PM
    Author     : Linh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>learner-profile</title>
        <link rel="stylesheet" href="../css/learner/learner-profile.css">
    </head>
    <body>
        <div class="container">
            <div class="main-body">

                <!-- Breadcrumb -->
                <nav aria-label="breadcrumb" class="main-breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="../HomeController">Home</a></li>
                        <li class="breadcrumb-item"><a href="learner-profile">User</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Learner Profile</li>
                    </ol>
                </nav>
                <!-- /Breadcrumb -->

                <div class="row gutters-sm">
                    <div class="col-md-4 mb-3">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex flex-column align-items-center text-center">
                                    <img src="../images/${learner.getImage()}" alt="Learner" class="rounded-circle" width="150">
                                    <div class="mt-3">
                                        <h4>${learner.getFullname()}</h4>
                                        <p class="text-secondary mb-1">Leaner</p>
                                        <p class="text-muted font-size-sm">${learner.getAddress()}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card mt-3">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                    <h6 class="d-flex align-items-center mb-3"><i class="material-icons text-info mr-2">Các triệu chứng covid-19</i></h6>
                                </li>
                                <c:if test="${list_symtomp == null}">
                                    <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                        ${mess} 
                                    </li>
                                </c:if>
                                <c:forEach items="${list_symtomp}" var="s">
                                    <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                        - ${s.getSymptomName()}
                                    </li>
                                </c:forEach>
                                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                    <a class="btn btn-info " target="__blank" href="${pageContext.request.contextPath}/health-declaration">Sửa triệu chứng</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="card mb-3">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Email</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${learner.getEmail()}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Số điện thoại</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${learner.getPhone()}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Giới tính</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${learner.isGender() == "true"? "Nam":"Nữ"}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Ngày sinh</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${learner.getDob()}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <h6 class="mb-0">Địa chỉ</h6>
                                    </div>
                                    <div class="col-sm-9 text-secondary">
                                        ${learner.getAddress()}
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-9">
                                        <a class="btn btn-info " target="" href="../learner/edit_profile?learnerID=${learner.getLearnerID()}">Sửa</a>
                                    </div>
                                    <div class="col-sm-3">
                                        <a class="btn btn-info " target="__blank" href="../changePassword?id=${learner.getLearnerID()}">Đổi mật khẩu</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row gutters-sm">
                            <div class="col-sm-12 mb-12">
                                <div class="card h-100">
                                    <div class="card-body">
                                        <h6 class="d-flex align-items-center mb-3"><i class="material-icons text-info mr-2">Các khóa học</i></h6>
                                        <c:if test="${list_enroll.size() == 0}">
                                            <small>Bạn chưa đăng kí khóa học nào</small>
                                        </c:if>
                                        <c:forEach items="${list_enroll}" var="e">
                                            <c:forEach items="${list_course}" var="c">
                                                <c:if test="${e.getCourseID() == c.getCourseID()}">
                                                    <small>${c.getCourseName()}</small>
                                                    <div class="progress mb-3" style="height: 5px">
                                                        <div class="progress-bar bg-primary" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>

                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>