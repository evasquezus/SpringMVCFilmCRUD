package com.skilldistillery.film.database;

import java.sql.SQLException;

import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	Film findFilmById(int filmID);

//	Actor findActorById(int actorId);
//
//	List<Actor> findActorsByFilmId(int filmId);
//
//	List<Film> findFilmByKW(String filmKW);
//
	Film addFilm(Film film);
	
	void deleteFilm(Film filmId);
}
