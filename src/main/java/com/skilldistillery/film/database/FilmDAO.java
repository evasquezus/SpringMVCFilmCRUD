package com.skilldistillery.film.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	Film findFilmById(int filmID);

	Actor findActorById(int actorId);

	List<Actor> findActorsByFilmId(int filmId);

	List<Film> findFilmByKW(String filmKW) throws SQLException;

	Film createFilm(Film film);

	Film addFilm(Film film);

	public boolean deleteFilm(int filmId) throws SQLException;

}
