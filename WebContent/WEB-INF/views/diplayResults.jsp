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
<<<<<<< HEAD
=======
	<h2>Title :</h2>
	<p>${film.title}</p>
	<p>${film.description}</p>
	<p>${film.rating}</p>
	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<c:out value="${film.title} "></c:out>
				<c:out value="${film.description} "></c:out>
=======
>>>>>>> 16b704cb5b538261e8eae813683ddf054646e526
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
>>>>>>> 7d14341a853f74264f8444c768acca0f08360603
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