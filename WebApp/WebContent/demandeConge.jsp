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
		if ( session.getAttribute("auth") != "yes" )
			response.sendRedirect("index.jsp") ;
	
		Cookie[] cookies = request.getCookies() ;
		String username = "" ;
		for ( Cookie c : cookies )
			if ( c.getName().equals("username") )
				username = c.getValue() ;
	%>

	<div class="container">
		<h1 class="h"> 
			Hi <% out.print(username); %> please fill the form below to request a leave 
		</h1>
			
		<form method="POST" action="demande">
			<input type="number" min="1" max="365" name="day" placeholder="number (day) between 1 and 365"> <br>
			<br>
			<input type="submit" value="Validate">
		</form>
			
		<form action="logout" method="POST">
    		<input type="submit" value="Logout" />
		</form>
		
	</div>
		
	<br><br>
	
	<div class="footer">
		<p> © 2015 Luís Abreu, Rossana Cammardella </p>
	</div>
</body>
</html>