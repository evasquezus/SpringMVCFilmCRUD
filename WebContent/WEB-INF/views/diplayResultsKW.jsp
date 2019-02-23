<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film By KW</title>
</head>
<body>
	<h1>Displaying Results By KW</h1>
	<h2>Title</h2>
	<p>${film.title}</p>
	<h2>Description</h2>
	<p>${film.description}</p>
	<h2>Rating</h2>
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