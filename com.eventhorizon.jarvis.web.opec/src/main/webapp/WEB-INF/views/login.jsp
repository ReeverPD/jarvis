<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${lang} }">
	<head>
		<meta charset="UTF-8">
    	<meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<link rel="icon" type="image/ico" href="${pageContext.servletContext.contextPath}/resources/img/favicon.ico">
		<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/login.css">
		<!-- jQuery framework -->
        <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
        <!-- validation -->
        <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery-validation/jquery.validate.js"></script>
    
		<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300 ' rel='stylesheet'>
		
		
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Jarvis - OPEC</title>
		
		<script type="text/javascript">
        (function(a){a.fn.vAlign=function(){return this.each(function(){var b=a(this).height(),c=a(this).outerHeight(),b=(b+(c-b))/2;a(this).css("margin-top","-"+b+"px");a(this).css("top","50%");a(this).css("position","absolute")})}})(jQuery);(function(a){a.fn.hAlign=function(){return this.each(function(){var b=a(this).width(),c=a(this).outerWidth(),b=(b+(c-b))/2;a(this).css("margin-left","-"+b+"px");a(this).css("left","50%");a(this).css("position","absolute")})}})(jQuery);
        $(document).ready(function() {
            if($('#login-wrapper').length) {
                $("#login-wrapper").vAlign().hAlign()
            };
            if($('#login-validate').length) {
                $('#login-validate').validate({
                    onkeyup: false,
                    errorClass: 'error',
                    rules: {
                        login_name: { required: true },
                        login_password: { required: true }
                    }
                })
            }
            if($('#forgot-validate').length) {
                $('#forgot-validate').validate({
                    onkeyup: false,
                    errorClass: 'error',
                    rules: {
                        forgot_email: { required: true, email: true }
                    }
                })
            }
            $('#pass_login').click(function() {
                $('.panel:visible').slideUp('200',function() {
                    $('.panel').not($(this)).slideDown('200');
                });
                $(this).children('span').toggle();
            });
        });
    </script>
        
		
	</head>
	<body>
		<div id="login-wrapper" class="clearfix">
        <div class="main-col">
            <img src="img/beoro.png" alt="" class="logo_img" />
            <div class="panel">
                <p class="heading_main">Account Login</p>
                <form id="login-validate" action="dashboard.html" method="post">
                    <label for="login_name">Login</label>
                    <input type="text" id="login_name" name="login_name" value="Jonathan Smith" />
                    <label for="login_password">Password</label>
                    <input type="password" id="login_password" name="login_password" value="password" />
                    <label for="login_remember" class="checkbox"><input type="checkbox" id="login_remember" name="login_remember" /> Remember me</label>
                    <div class="submit_sect">
                        <button type="submit" class="btn btn-beoro-3">Login</button>
                    </div>
                </form>
            </div>
            
        
	</body>
</html>