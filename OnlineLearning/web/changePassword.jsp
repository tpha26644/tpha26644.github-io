<%-- 
    Document   : changePassword
    Created on : Feb 21, 2022, 1:43:33 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->
                <h2 class="active"> Change Your Password </h2>    
                <c:if test="${error != null}">
                    <div class="alert alert-danger" role="alert">
                        ${error}
                    </div>
                </c:if>

                <!-- Reset Form -->
                <form action="changePassword?id=${id}" method="POST">
                    <input type="password" class="fadeIn second" name="oldPassword" placeholder="Please enter your old password." required="true">
                    <input type="password" class="fadeIn second" name="newPassword" placeholder="Please enter your new password." required="true">
                    <input type="password" class="fadeIn second" name="retypeNewPassword" placeholder="Please retype your new password." required="true">
                    <input type="submit" name="submit" class="fadeIn fifth" value="Change Password">
                </form>                                
            </div>
    </body> 
    <script src="js/login.js" type="text/javascript"></script>
</html>
