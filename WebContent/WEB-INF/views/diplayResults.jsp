<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film By ID</title>
</head>
<img
	src="https://www.streetsatsouthpoint.com/content/dam/rw-2/images/mall-images/mall-features/movies-desktop.png"
	style="max-width: 100%">
<body>
	<h1>Displaying Results</h1>
	<br>

	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<p>
					Title:
					<c:out value="${film.title} "></c:out>
				</p>
				<p>
					Description:
					<c:out value="${film.description} "></c:out>
				</p>
				<p>
					Release Year:
					<c:out value="${film.release_year} "></c:out>
				</p>
				<p>
					Language ID:
					<c:out value="${film.language_id} "></c:out>
				</p>
				<p>
					Rental Length:
					<c:out value="${film.rental_duration} "></c:out>
				</p>
				<p>
					Rental Rate:
					<c:out value="${film.rental_rate} "></c:out>
				</p>
				<p>
					Film Length:
					<c:out value="${film.length} "></c:out>
				</p>
				<p>
					Replacement Cost:
					<c:out value="${film.replacement_cost} "></c:out>
				</p>
				<p>
					Rating:
					<c:out value="${film.rating} "></c:out>
				</p>

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


