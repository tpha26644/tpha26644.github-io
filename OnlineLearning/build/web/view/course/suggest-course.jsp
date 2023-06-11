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
<section class="section gb nopadtop">
  <div class="container">
    <div class="boxed boxedp4">
      <div class="shop-top">
        <div class="clearfix">
          <div class="pull-left">
            <h4> Course for you</h4>
          </div>

        </div>
      </div>
      <div class="row mb-3 blog-grid shop-grid w-100">
        <!blog-grid shop-grid!>

        <c:forEach items="${listCourseSuggest}" var="course" end="2">                                
            <div class="col-md-4" style="height: 28em">
              <div class="course-box shop-wrapper" style="border-radius: 5px">
                <div class="image-wrap entry">
                  <img style="max-width: 100%; max-height: 100%;" src="images/courses/${course.getImage()}" alt="" class="img-responsive">
                  <div class="magnifier">
                    <a href="" title=""><i class="flaticon-add"></i></a>
                  </div>
                </div>
                <!-- end image-wrap -->
                <div class="course-details shop-box text-center">
                  <h4>
                    <a href="EnrollController?courseId=${course.getCourseID()}" title="">${course.getCourseName()}</a>
                    <small>${course.getCategory().getCategoryName()}</small>
                  </h4>
                </div>
                <!-- end details -->
                <div class="course-footer clearfix">
                  <div class="pull-left">
                    <ul class="list-inline">
                      <li><a href="#"><i class="fas fa-atlas"></i>Learn Now!</a></li>
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

    </div>
  </div><!-- end container -->
</section>