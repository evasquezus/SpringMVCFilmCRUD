<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Deleted</title>
</head>
<body>
	<c:choose>
		<c:when test="${test}">
			<p>Movie is removed</p>
			<a href="index.html">return to main menu</a>
		</c:when>
		<c:otherwise>
			<p>No film found</p>
			<a href="index.html">return to main menu</a>
		</c:otherwise>
	</c:choose>
</body>
</html>