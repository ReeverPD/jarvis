<%-- 
    Document   : main-theme
    Created on : Fev 25, 2014, 4:48:43 PM
    Author     : iuriandreazza
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>J.A.R.V.I.S System - { tipz.com Opec } :: <sitemesh:write property='title'/></title>
	<meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
	
	<script type="text/javascript">
        APPLICATION_CONTEXT_PATH = '${pageContext.servletContext.contextPath}';
    </script>
	
	<link rel="icon" type="image/ico" href="${pageContext.servletContext.contextPath}/resources/img/favicon.ico">

    <!-- common stylesheets-->
      <!-- bootstrap framework css -->
          <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css">
          <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap-responsive.min.css">
      <!-- iconSweet2 icon pack (16x16) -->
          <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/img/icsw2_16/icsw2_16.css">
      <!-- splashy icon pack -->
          <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/img/splashy/splashy.css">
      <!-- flag icons -->
          <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/img/flags/flags.css">
      <!-- power tooltips -->
          <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/js/lib/powertip/jquery.powertip.css">
      <!-- google web fonts -->
          <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Abel">
          <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300">

  <!-- aditional stylesheets -->
      <!-- colorbox -->
          <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/js/lib/colorbox/colorbox.css">
      <!--fullcalendar -->
          <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/js/lib/fullcalendar/fullcalendar_beoro.css">


      <!-- main stylesheet -->
          <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/beoro.css">

      <!--[if lte IE 8]><link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/ie8.css"><![endif]-->
      <!--[if IE 9]><link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/ie9.css"><![endif]-->
          
      <!--[if lt IE 9]>
          <script src="${pageContext.servletContext.contextPath}/resources/js/ie/html5shiv.min.js"></script>
          <script src="${pageContext.servletContext.contextPath}/resources/js/ie/respond.min.js"></script>
          <script src="${pageContext.servletContext.contextPath}/resources/js/lib/flot-charts/excanvas.min.js"></script>
      <![endif]-->
	
	
	
</head>
<body class="bg_d">

<!-- main wrapper (without footer) -->    
        <div class="main-wrapper">
        <!-- top bar -->
            <div class="navbar navbar-fixed-top">
                <div class="navbar-inner">
                    <div class="container">
                        <div class="pull-right top-search">
                            <form action="" >
                                <input type="text" name="q" id="q-main">
                                <button class="btn"><i class="icon-search"></i></button>
                            </form>
                        </div>
                        <div id="fade-menu" class="pull-left">
                            <ul class="clearfix" id="mobile-nav">
                            	<c:forEach items="${menus}" var="menu">
                            		<li>
	                            		<a href="javascript:void(0)">${menu.label}</a>
	                            		<ul>
		                            		<c:forEach items="${menu.items}" var="item">
		                            			<li><a href="${item.link}">${item.label}</a></li>
		                            		</c:forEach>
	                            		</ul>
	                            	</li>
                            	</c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        <!-- header -->
            <header>
                <div class="container">
                    <div class="row">
                        <div class="span3">
                            <div class="main-logo"><a href="${pageContext.servletContext.contextPath}/app/home"><img src="${pageContext.servletContext.contextPath}/resources/img/beoro_logo.png" alt="Beoro Admin"></a></div>
                        </div>
                        <div class="span5">
                            <nav class="nav-icons">
                                <ul>
                                    <li><a href="javascript:void(0)" class="ptip_s" title="Dashboard"><i class="icsw16-home"></i></a></li>
                                    <li><a href="javascript:void(0)" class="ptip_s" title="Content"><i class="icsw16-create-write"></i></a></li>
                                    <li><a href="javascript:void(0)" class="ptip_s" title="Mailbox"><i class="icsw16-mail"></i><span class="badge badge-info">6</span></a></li>
                                    <li><a href="javascript:void(0)" class="ptip_s" title="Comments"><i class="icsw16-speech-bubbles"></i><span class="badge badge-important">14</span></a></li>
                                    <li class="active"><span class="ptip_s" title="Statistics (active)"><i class="icsw16-graph"></i></span></li>
                                    <li><a href="javascript:void(0)" class="ptip_s" title="Settings"><i class="icsw16-cog"></i></a></li>
                                </ul>
                             </nav>
                        </div>
                        <div class="span4">
                            <div class="user-box">
                                <div class="user-box-inner">
                                    <img src="${userPicture}" alt="" class="user-avatar img-avatar">
                                    <div class="user-info">
                                        Welcome, <strong>${userName}</strong>
                                        <ul class="unstyled">
                                            <li><a href="#">Settings</a></li>
                                            <li>&middot;</li>
                                            <li><a href="${pageContext.servletContext.contextPath}/logout">Logout</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>

        <!-- breadcrumbs -->
            <div class="container">
                <ul id="breadcrumbs">
                    <li><a href="javascript:void(0)"><i class="icon-home"></i></a></li>
                    <li><a href="javascript:void(0)">Content</a></li>
                    <li><a href="javascript:void(0)">Article: Lorem ipsum dolor...</a></li>
                    <li><a href="javascript:void(0)">Comments</a></li>
                    <li><span>Lorem ipsum dolor sit amet...</span></li>
                </ul>
            </div>
            
        <!-- main content -->
            <div class="container">
            	<sitemesh:write property='body'/>
            </div>
            <div class="footer_space"></div>
        </div> 

    <!-- footer --> 
        <footer>
            <div class="container">
                <div class="row">
                    <div class="span5">
                        <div>&copy; tipz.com ${year}</div>
                    </div>
                    <div class="span7">
                        <ul class="unstyled">
                            <li><a href="http://www.eventhorizon.com">Event Horizon Company</a></li>
                            <li>&middot;</li>
                            <li><a href="http://www.reeverpd.com.br">Reever P&D</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
        
        
        
    <!-- Common JS -->
        <!-- jQuery framework -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js"></script>
        <!-- bootstrap Framework plugins -->
            <script src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
        <!-- top menu -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.fademenu.js"></script>
        <!-- top mobile menu -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/selectnav.min.js"></script>
        <!-- actual width/height of hidden DOM elements -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.actual.min.js"></script>
        <!-- jquery easing animations -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.easing.1.3.min.js"></script>
        <!-- power tooltips -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/powertip/jquery.powertip-1.1.0.min.js"></script>
        <!-- date library -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/moment.min.js"></script>
        <!-- common functions -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/beoro_common.js"></script>

<!-- Head Section -->
        <sitemesh:write property='head'/>

    <!-- Dashboard JS -->
    
    
    
        <!-- jQuery UI -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery-ui/jquery-ui-1.9.2.custom.min.js"></script>
        <!-- touch event support for jQuery UI -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/jquery-ui/jquery.ui.touch-punch.min.js"></script>
        <!-- colorbox -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/colorbox/jquery.colorbox.min.js"></script>
        <!-- fullcalendar -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/fullcalendar/fullcalendar.min.js"></script>
        <!-- flot charts -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/flot-charts/jquery.flot.js"></script>
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/flot-charts/jquery.flot.resize.js"></script>
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/flot-charts/jquery.flot.pie.js"></script>
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/flot-charts/jquery.flot.orderBars.js"></script>
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/flot-charts/jquery.flot.tooltip.js"></script>
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/flot-charts/jquery.flot.time.js"></script>
        <!-- responsive carousel -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/carousel/plugin.min.js"></script>
        <!-- responsive image grid -->
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/wookmark/jquery.imagesloaded.min.js"></script>
            <script src="${pageContext.servletContext.contextPath}/resources/js/lib/wookmark/jquery.wookmark.min.js"></script>

            <script src="${pageContext.servletContext.contextPath}/resources/js/pages/beoro_dashboard.js"></script>



</body>
</html>