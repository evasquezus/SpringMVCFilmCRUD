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
	<h1>Displaying Results</h1>
	<br>

	<c:choose>
		<c:when test="${! empty filmList}">
			<c:forEach var="film" items="${filmList}">
					href="<c:url value="GetFilmById.do?filmId=${films.id}" />">ID: <c:out
					value="${ film.id}" />
				<br> 
				Title: <c:out value="${ film.title}" />
				<br>
					Description: <c:out value="${ film.description}" />
				<br>
			</c:forEach>
			<ul>
				<h1>Film title</h1>
				<c:out value="${filmkW.title} "></c:out>
				<br>
				<h1>Film rating</h1>
				<c:out value="${filmkW.rating} "></c:out>
				<br>
				<h1>Film description</h1>
				<c:out value="${filmkW.description} "></c:out>
				<br>
				<h1>Film rating</h1>
				<c:out value="${filmkW.rating} "></c:out>
				<br>
			</ul>
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


