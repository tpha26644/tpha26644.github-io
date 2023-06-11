<!Doctype html>
<html>
    <head>
        <title>Signup Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Official Signup Form Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- fonts -->
        <link href="//fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
        <!-- /fonts -->
        <!-- css -->
        <link href="css/learner/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/learner/register.css" rel="stylesheet" type="text/css" media="all"/>
        <!-- /css -->
    </head>
    <body>
        <h1 class="w3ls">Sign up</h1>
        <div class="content-w3ls">
            <div class="content-agile1">
                <h2 class="agileits1">Official</h2>
                <p class="agileits2">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
            </div>
            <div class="content-agile2">
                <form action="RegisterServlet?action=register" method="post">
                    <div class="form-control w3layouts"> 
                        <input type="text" id="name" name="name" placeholder="Full Name" title="Please enter your name" required="">
                    </div>

                    <div class="form-control w3layouts"> 
                        <input type="text" id="phone" name="phone" placeholder="Phone" title="Please enter your phone" required="">
                    </div>

                    <div class="form-control w3layouts"> 
                        <input type="text" id="address" name="email" placeholder="Email" title="Please enter your email" required="">
                    </div>

                    <div class="form-control w3layouts">	
                        <input type="text" id="user" name="user" placeholder="Username" title="Please enter your username" required="">
                    </div>

                    <div class="form-control agileinfo">	
                        <input type="password" class="lock" name="pass" placeholder="Password" id="password1" required="">
                    </div>	

                    <div class="form-control agileinfo">	
                        <input type="password" class="lock" name="confirm-password" placeholder="Confirm Password" id="password2" required="">
                    </div>		
                    <input type="submit" class="register" value="Register" name="submit">
                </form>
                <script type="text/javascript">
                    window.onload = function () {
                        document.getElementById("password1").onchange = validatePassword;
                        document.getElementById("password2").onchange = validatePassword;
                    }
                    function validatePassword() {
                        var pass2 = document.getElementById("password2").value;
                        var pass1 = document.getElementById("password1").value;
                        if (pass1 != pass2)
                            document.getElementById("password2").setCustomValidity("Passwords Don't Match");
                        else
                            document.getElementById("password2").setCustomValidity('');
                        //empty string means no validation error
                    }
                </script>
            </div>
            <div class="clear"></div>
        </div>
    </body>
</html>