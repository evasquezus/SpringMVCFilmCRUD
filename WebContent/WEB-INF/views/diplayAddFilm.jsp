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
			<p>Film Not Added</p>
			<a href="index.html">return to main menu</a>
		</c:otherwise>
	</c:choose>

	<h2>
		<a href="index.html">return to main menu</a>
	</h2>

</body>
</html>


