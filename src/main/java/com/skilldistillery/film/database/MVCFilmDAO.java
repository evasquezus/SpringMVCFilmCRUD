package com.skilldistillery.film.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Repository
public class MVCFilmDAO implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String user = "student";
	private static final String pass = "student";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}

	@Override
	public Film addFilm(Film addFilm) {
		Film filmToBeInserted = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false); // START TRANSACTION
			String sql = "INSERT INTO film ( title, description, release_year, replacement_cost, rating) "
					+ " VALUES (?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, addFilm.getTitle());
			stmt.setString(2, addFilm.getDescription());
			stmt.setLong(3, addFilm.getRelease_year());
			stmt.setDouble(4, addFilm.getReplacement_cost());
			stmt.setString(5, addFilm.getRating());
//			ResultSet updateCount = stmt.executeQuery();

		} catch (Exception e) {
		}

		return filmToBeInserted;

	}

	@Override
	public Film findFilmById(int filmID) {
		Film film = null;
		Connection conn;
		String sql = "SELECT id, title, description, rating, release_year, rental_rate, language_id,replacement_cost, length,rental_duration FROM film  WHERE id = ?";

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmID);
			ResultSet filmResult = stmt.executeQuery();
			while (filmResult.next()) {
				int id = filmResult.getInt("id");
				String title = filmResult.getString("title");
				String description = filmResult.getString("description");
				int release_year = filmResult.getInt("release_year");
				String language_id = filmResult.getString("language_id");
				int rental_duration = filmResult.getInt("rental_duration");
				double rental_rate = filmResult.getDouble("rental_rate");
				int length = filmResult.getInt("length");
				String rating = filmResult.getString("rating");
				double replacement_cost = filmResult.getDouble("replacement_cost");
				List<Actor> actors = new ArrayList<>();
				film = new Film(id, title, description, release_year, language_id, rental_duration, rental_rate, length,
						replacement_cost, rating, actors);
				return film;

			}

			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return film;
	}

//	@Override
//	public Actor findActorById(int actorID) {
//		Actor actor = null;
//		try {
//			Connection conn = DriverManager.getConnection(URL, user, pass);
//			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, actorID);
//			ResultSet actorResult = stmt.executeQuery();
//			while (actorResult.next()) {
//				int id = actorResult.getInt("id");
//				String firstName = actorResult.getString("first_name");
//				String lastName = actorResult.getString("last_name");
//				String title = actorResult.getString("title");
//				String description = actorResult.getString("description");
//				int releaseYear = actorResult.getInt("release_year");
//				String languageID = actorResult.getString("language_id");
//				int rentalDuration = actorResult.getInt("rental_duration");
//				actor = new Actor(id, firstName, lastName);
//				return actor;
//			}
//
//			actorResult.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return actor;
//	}
//
//	@Override
//	public List<Actor> findActorsByFilmId(int actorID) {
//		List<Actor> actors = new ArrayList<>();
//		Actor actor = null;
//		try {
//			Connection conn = DriverManager.getConnection(URL, user, pass);
//			String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor actor JOIN film_actor filmact ON act.id = filmact.actor_id JOIN film ON filmact.film_id = film.id WHERE film.id = ?";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, actorID);
//			ResultSet actorResult = stmt.executeQuery();
//
//			while (actorResult.next()) {
//				String firstName = actorResult.getString("actor.first_name");
//				String lastName = actorResult.getString("actor.last_name");
//				int id = actorResult.getInt("actor.id");
//				actor = new Actor(id, firstName, lastName);
//				actors.add(actor);
//
//			}
//
//			actorResult.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return actors;
//	}
//
//	@Override
//	public List<Film> findFilmByKW(String filmKW) {
//		List<Film> films = new ArrayList<>();
//		Film film = null;
//		try {
//			Connection conn = DriverManager.getConnection(URL, user, pass);
//			String sql = "SELECT * FROM film WHERE title LIKE ? OR description like ?;";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, "%" + filmKW + "%");
//			stmt.setString(2, "%" + filmKW + "%");
//			ResultSet filmResult = stmt.executeQuery();
//
//			while (filmResult.next()) {
//
//				films.add(findFilmById(filmResult.getInt("id")));
//
//			}
//
//			conn.close();
//			filmResult.close();
//			stmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return films;
//	}
}