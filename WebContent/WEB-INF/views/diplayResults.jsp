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
	
	<p>${film.title}</p>
	<p>${film.description}</p>
	<p>${film.rating}</p>
	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<c:out value="${film.title} "></c:out>
				<c:out value="${film.description} "></c:out>
				<c:out value="${film.rating} "></c:out>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No Film Found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>