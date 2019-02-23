package com.skilldistillery.film.database;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
	Film findFilmById(int filmId);

	Actor findActorById(int actorId);

	List<Actor> findActorsByFilmId(int filmId);

	List<Film> findFilmByKW(String filmKW);
}
