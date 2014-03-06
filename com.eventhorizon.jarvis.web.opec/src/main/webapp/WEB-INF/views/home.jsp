<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${lang}">
<head>
	<title>Home / Dashboard</title>

</head>
<body>
		HOME

    <content tag="footerLay">
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

        <script src="${pageContext.servletContext.contextPath}/resources/js/pages/dashboard.js"></script>

    </div>

</body>
</html>