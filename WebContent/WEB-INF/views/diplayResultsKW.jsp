<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film By KW</title>
</head>
<body>
	<h1>Displaying Results By KW</h1>
	<br>

	<c:choose>
		<c:when test="${! empty film}">
			<c:forEach var="film" items="${film}">
				<c:out value="${ film.id}" />
				<br> 
				Title: <c:out value="${ film.title}" />
				<br>
				Description: <c:out value="${ film.description}" />
				<br>
				<br>
			</c:forEach>

		</c:when>
		<c:otherwise>
			<p>No Film Found</p>
		</c:otherwise>
	</c:choose>
	<br>
	<h3>Would you like to delete this film?</h3>

	<br>
	<a href="index.html">Return to main menu</a>
</body>
</html>


