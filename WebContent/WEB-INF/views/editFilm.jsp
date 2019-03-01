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
		ID: <h1>${film.id}</h1><br>
	<form action="editFilm.do" method="POST">
	
		
		
		
		Title: <input type="text" name="title" value = "${film.title}"><br>
		Description: <input type="text" name="description" value = "${film.description}"><br>
		Release Year: <input type="text" name="release_year" value = "${film.release_year}"><br>
		Language ID: <input type="text" name="language_id" value = "${film.language_id}"><br>
		Rental Length: <input type="text" name="rental_duration" value = "${film.rental_duration}"><br>
		Rental Rate: <input type="text" name="rental_rate" value = "${film.rental_rate}"><br>
		Film Length: <input type="text" name="length" value = "${film.length}"><br>
		Replacement Cost: <input type="text" name="replacement_cost" value = "${film.replacement_cost}"><br>
		Rating: <input type="text" name="rating" value = "${film.rating}"><br>
		<input name ="id" type = "hidden" value = "${film.id}"/>
		<input type="submit" value="Submit" name="EditFilmButton" />
	</form>
	</div>
	</body>
</html>