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
        <title>edit-profile</title>
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
                    </div>
                    <div class="col-md-8">
                        <div class="card mb-3">
                            <div class="card-body">
                                <form action="../learner/edit_profile" method="POST">
                                    <input type="hidden" name="learnerID" value="${learner.getLearnerID()}" />
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Thêm ảnh mới</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="hidden" name="image" value="${learner.getImage()}" />
                                            <input class="input-file" type="file" name="image_change" id="file">
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Họ và tên</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="fullname" class="form-control" id="exampleInputPassword1" value="${learner.getFullname()}">                     
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Email</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="email" class="form-control" id="exampleInputPassword1" value="${learner.getEmail()}">                     
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Số điện thoại</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="phone" class="form-control" id="exampleInputPassword1" value="${learner.getPhone()}">                     
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Giới tính</h6>
                                        </div>
                                        <div class="col-sm-3 text-secondary">
                                            <input class="form-check-input" type="radio" name="gender" id="exampleRadios1" value="true" ${learner.isGender() == true ? "checked":""}>
                                            <label class="form-check-label" for="exampleRadios1">
                                                Nam
                                            </label>
                                        </div>
                                        <div class="col-sm-3 text-secondary">
                                            <input class="form-check-input" type="radio" name="gender" id="exampleRadios1" value="false" ${learner.isGender() == false ? "checked":""}>
                                            <label class="form-check-label" for="exampleRadios1">
                                                Nữ
                                            </label>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Ngày sinh</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="date" name="dob" class="form-control" id="exampleInputPassword1" value="${learner.getDob()}">
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Địa chỉ</h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" name="address" class="form-control" id="exampleInputPassword1" value="${learner.getAddress()}">                     
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-9">
                                            <button class="btn btn-primary" type="submit">Sửa</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>


                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
