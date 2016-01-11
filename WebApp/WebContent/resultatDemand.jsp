<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> WebApp Project</title>
</head>
<body>

	<% 
		String result = (String)request.getAttribute("result");
		int day = (int)request.getAttribute("day");
		
		String msg ;
		
		if ( result.equals("available") )
			msg = "Success. The day " + day + " is available. Leave request approved!"  ;
		else
			msg = "Failure. The day " + day + " is not available. <a href='demandeConge.jsp'>Try a different day.</a>" ;
	%>
	
	<div class="container">
		<h1 class="h"> Results of your request </h1>
			
		<p class="<%=result%>"> <% out.print(msg) ; %> </p>
			
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