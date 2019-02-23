package com.skilldistillery.film.database;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	Film findFilmById(int filmID);

	Actor findActorById(int actorId);
//
	List<Actor> findActorsByFilmId(int filmId);
//
	List<Film> findFilmByKW(String filmKW);
//
<<<<<<< HEAD
	Film createFilm(Film film);
=======
	Film addFilm(Film film);
>>>>>>> 62f2410e847da49adde974cecc940bd8d10d1721
}
