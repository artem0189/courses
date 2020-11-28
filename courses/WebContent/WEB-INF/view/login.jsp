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
	<form action="login" method="post">
		<input type="hidden" name="command" value="login">

		<a>	
			Username: <input type="text" name="username" required="required" /> <br> 
			Password: <input type="password" name="password" required="required" /> <br> 
			<input type="submit" name="submit" value="Login" id="button" />
		</a>
	</form>
	<h4> <c:out  value = "${requestScope.error}"/><br>	</h4>
</body>
</html>