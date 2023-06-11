<%-- 
    Document   : HealthDeclaration
    Created on : 15-Feb-2022, 17:26:31
    Author     : NHATNAM-PC
--%>
<%@page import="entity.Account"%>
<%@page import="entity.Learner"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
      function hideURLbar(){ window.scrollTo(0,1); } </script>
    <script>
        $(window).on("load resize ", function () {
          var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
          $('.tbl-header').css({'padding-right': scrollWidth});
        }).resize();
    </script>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" media="all" />

    <link href="//fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext,vietnamese" rel="stylesheet">

    <title>Health Declaration</title>
  </head>
  <body>
    <div class="main fadeInDown ">
      
      <div class="main-w3l">
        <h1 class="logo-w3 active"></h1>
        <div class="w3layouts-main">
          <h2 style="margin-bottom:30px;">Các triệu chứng bạn đang có<span class="fadeIn first"></span></h2>
          <div class="tableChoiceData mb-20">
            <div class="cols-left">
              <form action="health-declaration" method="POST">
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th scope="col">Triệu chứng</th>
                      <th scope="col" style="width: 70px" class="text-center">Có</th>
                      <th scope="col" style="width: 70px" class="text-center">Không</th>
                    </tr>
                  </thead>
                  <tbody>

                    <c:forEach items="${listSymptomOfLearner}" var="i">
                        <tr>
                          <td>
                            ${i.symptomName} <span class="text-required">(*)</span><br />
                            <label
                                class="error"
                                for="symp${i.getStringSymptomId()}"
                                ></label>
                          </td>
                          <td class="text-center" style="width: 70px">
                            <input
                                type="Radio"
                                class="style-radio"
                                name="symp${i.getStringSymptomId()}"
                                value="1"
                                checked
                                />
                          </td>
                          <td class="text-center" style="width: 70px">
                            <input
                                type="Radio"
                                class="style-radio"
                                name="symp${i.getStringSymptomId()}"
                                value="0"
                                ${(i.healthStatus == 0 ? "checked" : "")}
                          </td>
                        </tr>
                    </c:forEach>
                  </tbody>
                </table>
                <input type="submit" value="Submit" name="submit" />
              </form>

            </div>

          </div>
        </div>

        <div class="footer-w3l"></div>
      </div>
    </div>
    

    <style>
      h1{
          font-size: 30px;
          color: #fff;
          text-transform: uppercase;
          font-weight: 300;
          text-align: center;
          margin-bottom: 15px;
      }
      table{
          width:100%;
          table-layout: fixed;
      }
      .tbl-header{
          background-color: rgba(255,255,255,0.3);
      }
      .tbl-content{
          height:300px;
          overflow-x:auto;
          margin-top: 0px;
          border: 1px solid rgba(255,255,255,0.3);
      }
      th{
          padding: 20px 15px;
          text-align: left;
          font-weight: 500;
          font-size: 18px;
          color: #fff;
          text-transform: uppercase;
      }
      td{
          padding: 12px;
          text-align: left;
          vertical-align:middle;
          font-weight: 300;
          font-size: 15px;
          color: #fff;
          border-bottom: solid 1px rgba(255,255,255,0.1);
      }


      /* demo styles */

/*      @import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
      body{
                    background: -webkit-linear-gradient(left, #25c481, #25b7c4);
                    background: linear-gradient(to right, #25c481, #25b7c4);
          font-family: 'Roboto', sans-serif;
      }*/
      section{
          margin: 50px;
      }


      /* follow me template */
      .made-with-love {
          margin-top: 40px;
          padding: 10px;
          clear: left;
          text-align: center;
          font-size: 10px;
          font-family: arial;
          color: #fff;
      }
      .made-with-love i {
          font-style: normal;
          color: #F50057;
          font-size: 14px;
          position: relative;
          top: 2px;
      }
      .made-with-love a {
          color: #fff;
          text-decoration: none;
      }
      .made-with-love a:hover {
          text-decoration: underline;
      }


      /* for custom scrollbar for webkit browser*/

      ::-webkit-scrollbar {
          width: 6px;
      } 
      ::-webkit-scrollbar-track {
          -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
      } 
      ::-webkit-scrollbar-thumb {
          -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
      }

      @media(max-width: 1440px){
          .w3layouts-main {
              width: 75%;
          }
      }
    </style>

  </body>
</html>
