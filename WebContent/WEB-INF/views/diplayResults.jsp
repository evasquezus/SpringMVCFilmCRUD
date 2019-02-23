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
      <c:when test="${! empty film}  ">
        <ul>
          <li>${film.title}</li>
        </ul>
      </c:when>
      <c:otherwise>
        <p>No State Found</p>
      </c:otherwise>
    </c:choose>
</body>
</html>