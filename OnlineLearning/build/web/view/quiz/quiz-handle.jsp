<%-- 
    Document   : quiz-handle
    Created on : 20-Mar-2022, 02:23:43
    Author     : NHATNAM-PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <style>
      body {
          background-color: #eee
      }

      label.radio {
          cursor: pointer
      }

      label.radio input {
          position: absolute;
          top: 0;
          left: 0;
          visibility: hidden;
          pointer-events: none
      }

      label.radio span {
          padding: 5px 20px;
          border: 1px solid #0373c4;
          display: inline-block;
          color: #0373c4;
          /*width: 100px;*/
          text-align: center;
          border-radius: 3px;
          margin-top: 7px;
          text-transform: uppercase
      }

      label.radio input:checked+span {
          border-color: #0373c4;
          background-color: #0373c4;
          color: #fff
      }

      .ans {
          margin-left: 36px !important
      }

      .btn:focus {
          outline: 0 !important;
          box-shadow: none !important
      }

      .btn:active {
          outline: 0 !important;
          box-shadow: none !important
      }
    </style>
  </head>
  <body>
    <div class="container mt-5">
      <div class="d-flex justify-content-center row">
        <div class="col-md-10 col-lg-10">
          <c:if test='${showResult}'>
              <div class="border">
                <div class="question bg-white p-3 border-bottom">
                  <div class="d-flex flex-row justify-content-between align-items-center mcq">
                    <h3 class="text-result" style="color: #0373c4;">Bạn làm đúng <span style="font-size:34px">${countCorrectAns}/${questions.size()}</span> câu</h3>

                  </div>
                </div>
              </div>  
          </c:if>
          <form action="quiz-handle?action=finishQuiz&quizID=${quizID}" method="POST">
            <c:forEach items="${questions}" var="question" varStatus="loop">
                <div class="border">
                  <div class="question bg-white p-3 border-bottom">
                    <div class="d-flex flex-row justify-content-between align-items-center mcq">
                      <h4>Quiz 1</h4>
                      <span>(${loop.count} of ${questions.size()})</span>
                    </div>
                  </div>
                  <div class="question bg-white p-3 border-bottom">
                    <div class="d-flex flex-row align-items-center question-title">
                      <h3 class="text-danger">Q.</h3>
                      <h5 class="mt-1 ml-2">${question.content}</h5>
                    </div>
                    <c:forEach items="${answers}" var="ans">
                        <c:if test="${question.questionID == ans.question.questionID}">
                            <div class="ans ml-2">
                              <label class="radio"> 
                                <input type="radio" 
                                       name="${question.questionID}" 
                                       value="${ans.answer}" 
                                       ${(question.answer==ans.answer)?"checked":""}
                                       > 
                                <span>${ans.answer_content}</span>
                              </label>
                              <c:choose>
                                  <c:when test="${question.answer==ans.answer&&question.answer==question.correctAnswer}">
                                      <span class="text-success" style="font-weight: 700; font-size: 20px">Correct</span>
                                  </c:when>
                                  <c:when test="${question.answer==ans.answer&&question.answer!=question.correctAnswer}">
                                      <span class="text-danger" style="font-weight: 700; font-size: 20px">Wrong!</span>
                                  </c:when>
                                  <c:otherwise>
                                  </c:otherwise>
                              </c:choose>



                            </div>
                        </c:if>
                    </c:forEach>
                  </div>
                </div>  
            </c:forEach>
            <c:if test="${!showResult}">
                <div class="d-flex flex-row justify-content-end align-items-center p-3 bg-white">
                  <input class="btn btn-primary border-success align-items-center btn-success" type="submit" value="Submit" name="submit"/>
                </div>
            </c:if>

          </form>
        </div>
      </div>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" type="text/javascript"></script>
  </body>
</html>
