<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Film</title>
</head>
<body>
<h1>Edit Film</h1>
	<form action="EditFilm.do" method="POST">
		Title: <input type="text" name="title"><br>
		Description: <input type="text" name="description"><br>
		Release Year: <input type="text" name="release_year"><br>
		Language ID: <input type="text" name="language_id"><br>
		Rental Length: <input type="text" name="rental_duration"><br>
		Rental Rate: <input type="text" name="rental_rate"><br>
		Film Length: <input type="text" name="length"><br>
		Replacement Cost: <input type="text" name="replacement_cost"><br>
		Rating: <input type="text" name="rating"><br>
		<input type="submit" value="Submit" name="EditFilmButton" />
	</form>
	</div>
	</body>
</html>