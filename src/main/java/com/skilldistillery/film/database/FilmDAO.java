package com.skilldistillery.film.database;

import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	Film findFilmById(int filmID);
}
