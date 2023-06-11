<%-- 
    Document   : Login.jsp
    Created on : Oct 13, 2021, 1:38:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Space Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>

        <link href="css/login.css" rel="stylesheet" type="text/css" media="all" />

        <link href="//fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext,vietnamese" rel="stylesheet">

    </head>
    <body>
        <form action="RegisterServlet?action=checkf0" method="POST">
            <div class="main fadeInDown ">
                <div class="main-w3l">
                    <h1 class="logo-w3 active">Heath Care System</h1>
                    <div class="w3layouts-main" style="width: 800px; height: 300px">
                        <h2><span class="fadeIn first">Are you a Covid-19 patient?</span></h2>
                        <table border="0" style="margin-top: 100px">
                            <tr>
                                <td style="color: white; width: 800px; text-align: center">
                                    <input type="radio" name="sts" value="1" checked /><a style="margin-left: 20px; margin-right: 300px; font-size: 2.0em">Yes</a>
                                    <input type="radio" name="sts" value="0" /><a style="margin-left: 20px; font-size: 2.0em">No</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <input type="submit" name="submit" value="Next">
                    <div class="footer-w3l"></div>
                </div>
            </div>
        </form>
    </body>
</html>
