<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVCAPP</title>
</head>
<body>
	<h1>Displaying Results</h1>
	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<Strong>Title:</Strong>
				<c:out value="${film.title} "></c:out>
				<br>
				<Strong>Description:</Strong>
				<c:out value="${film.description} "></c:out>
				<br>
				<Strong>Rating:</Strong>
				<br>
				<c:out value="${film.release_year} "></c:out>
			</ul>
			<a href="index.html">return to main menu</a>
		</c:when>
		<c:otherwise>
			<p>No Film Found</p>
			<a href="index.html">return to main menu</a>
		</c:otherwise>
	</c:choose>
</body>
</html>