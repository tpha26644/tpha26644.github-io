<%-- 
    Document   : resetPassword
    Created on : Feb 20, 2022, 11:22:27 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" href="images/logo.ico" type="image/icon type">
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->
                <h2 class="active"> Reset Your Password </h2>    
                <c:if test="${error != null}">
                    <div class="alert alert-danger" role="alert">
                        ${error}
                    </div>
                </c:if>

                <!-- Reset Form -->
                <form action="resetPassword" method="POST">
                    <input type="text" class="fadeIn second" name="emailReset" placeholder="Please enter your email." required="true">                                        
                    <input type="submit" name="submit" class="fadeIn fifth" value="reset">
                </form>                                
            </div>
    </body> 
    <script src="js/login.js" type="text/javascript"></script>
</html>
