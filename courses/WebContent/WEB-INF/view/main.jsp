<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Main page</h1>
	<c:choose>
		<c:when test="${sessionScope.user == null}">
			<a href="login">Login</a>
		</c:when>
		<c:otherwise>
			<a href="?command=logout">Logout</a>
		</c:otherwise>
	</c:choose>
</body>
</html>