<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC APP</title>
</head>
<body>
	<h1>Get film by ID</h1>
	<form action="GetFilmById.do" method="GET">
		<p>
			<input type="text" name="FilmId" /> <input type="submit" value="Search" name ="FilmID" />
		</p>
	</form>
	
	<h1>Get film by Keyword</h1>
	<form action="GetKeyword.do" method="GET">
		<p>
			<input type="text" name="FilmId" /> <input type="submit" value="Search" name ="FilmKW"/>
		</p>
	</form>
	
	<h1>Add new Film</h1>
	<form action="AddFilm.do" method="POST">
		<p>
			<input type="text" name="FilmId" /> <input type="submit" value="Search" name ="AddFilm"/>
		</p>
	</form>
</body>
</html>