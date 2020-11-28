<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="registration" method="post">
	<input type="hidden" name="command" value="registration">
		<h1><c:out value = "${requestScope.error}"/></h1>
		<br>
		Enter username:
		<input type="text" name="username" required="required" /> <br /> 
		Enter password:
		<input type="password" name="password" required="required" /> <br />
		Enter name:
		<input type="text" name="name" required="required" /> <br /> 
		Enter surname:
		<input type="text" name="surname" required="required" /> <br /> 
		<input type="submit" name="submit" value="press me" />
	</form>
</body>
</html>