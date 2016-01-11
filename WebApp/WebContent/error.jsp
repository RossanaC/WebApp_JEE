<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebApp Project</title></head>
<body>

	<%
		// if the user is already authenticated, send him to the demandeConge.jsp page
		if ( session.getAttribute("auth") == "yes" )
			response.sendRedirect("demandeConge.jsp");
		else if ( session.getAttribute("auth") != "no" )
			response.sendRedirect("index.jsp") ;
	%>
	
	<jsp:useBean id="employee" class="authentication.Employee" scope="session"/>
	
	<div class="container">
		<h1 class="h failure"> Authentication failure </h1>
		<p>
			Failed to authenticate as 
			<span class="username"> <jsp:getProperty name="employee" property="username"/> </span>
		</p>
		<p> Return the the login page <a href="index.jsp"> here </a> </p>
	</div>
	
		
	<br><br>
	
	<div class="footer">
		<p> © 2015 Luís Abreu, Rossana Cammardella </p>
	</div>
	
</body>
</html>