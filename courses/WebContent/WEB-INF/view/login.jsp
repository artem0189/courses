<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="controller" method="post">
		<input type="hidden" name="command" value="login">

		<a>	
			Login: 	<input type="text" name="login" value="" /> <br> 
			Password: <input type="password" name="password" value="" /> <br> 
			<input type="submit" name="submit" value="Login" id="button" />
		</a>
	</form>
	<h4> <c:out  value = "${requestScope.error}"/><br>	</h4>
</body>
</html>