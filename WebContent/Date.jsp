<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Date</title>
</head>
<body>
	<%-- This is Declaration Tag  --%>

	<h1>The current Time is <%= new Date() %></h1>
	<%-- <jsp:include page="Footer.jsp"></jsp:include>
	<jsp:include page="Login.html"></jsp:include>
	--%>
	
	<jsp:forward page="/date1">
	<jsp:param value="java" name="data"/>
	</jsp:forward>
	
	
	
	
	<%-- <jsp:include page="/date1">
	<jsp:param value="java" name="data"/>
	</jsp:include>
	--%>
	
</body>
</html>