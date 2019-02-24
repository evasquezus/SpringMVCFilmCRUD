<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film By ID</title>
</head>
<img src="https://www.streetsatsouthpoint.com/content/dam/rw-2/images/mall-images/mall-features/movies-desktop.png" style="max-width:100%">
<body>
	<h1>Displaying Results</h1>
	<br>
	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<h1>Film title</h1>
				<c:out value="${film.title} "></c:out>
				<br>
				<h1>Film rating</h1>
				<c:out value="${film.rating} "></c:out>
				<br>
				<h1>Film description</h1>
				<c:out value="${film.description} "></c:out>
				<br>
				<h1>Film rating</h1>
				<c:out value="${film.rating} "></c:out>
				<br>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No Film Found</p>
		</c:otherwise>
	</c:choose>

	<h3>Would you like to delete this film?</h3>
	<form action="deleteFilm.do" method="POST" name="filmID">
		<input type="text" name="filmID" value="${film.id}" /> <input
			type="submit" name="filmID" value="Delete Film" />
	</form>
	<br>
	<a href="index.html">Return to main menu</a>
</body>
</html>


