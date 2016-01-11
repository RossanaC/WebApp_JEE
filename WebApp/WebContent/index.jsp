<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebApp Project</title>
</head>
<body>
	
	<%
		// if the user is already authenticated, send him to the demandeConge.jsp page
		if ( session.getAttribute("auth") == "yes" )
			response.sendRedirect("demandeConge.jsp");
	%>

	

	<div class="container">
		<h1 class="h"> Log in </h1>
			
		<form method="POST" action="auth">
			<input type="text" name="username" placeholder="username"> <br>
			<input type="password" name="password" placeholder="password"> <br>
			<br>
			<input type="submit" value="Authenticate" >
		</form>
	</div>
	
	<br><br>
	
	<div class="footer">
		<p> © 2015 Luís Abreu, Rossana Cammardella </p>
	</div>
	
</body>
</html>