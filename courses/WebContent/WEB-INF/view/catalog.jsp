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
	<h1>Catalog page</h1>
	<c:forEach var="course" items="${requestScope.courses}">
		<h1><c:out value="${course.title}" /></h1>
		<p><c:out value="${course.description}" /></p>
		<p><c:out value="${course.teacher.username}" /></p>
	</c:forEach>
</body>
</html>