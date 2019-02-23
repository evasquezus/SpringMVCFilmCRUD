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
<<<<<<< HEAD
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
				<c:out value="${film.rating} "></c:out>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No Film Found</p>
		</c:otherwise>
	</c:choose>
=======

	  <c:choose>
      <c:when test="${! empty film}  ">
        <ul>
          <li>${film.title}</li>
          <li>${film.description}</li>
          <li>${film.ratings}</li>
        </ul>
      </c:when>
      <c:otherwise>
        <p>No State Found</p>
      </c:otherwise>
    </c:choose>
>>>>>>> parent of e029027... downloading new base
</body>
</html>