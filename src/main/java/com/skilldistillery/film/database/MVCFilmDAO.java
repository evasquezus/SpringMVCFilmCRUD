package com.skilldistillery.film.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

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
		Film newFilm = null;
		Connection conn;

		String sql = "INSERT INTO film ( title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating) "
				+ " VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			conn.setAutoCommit(false);

			stmt.setString(1, addFilm.getTitle());
			stmt.setString(2, addFilm.getDescription());
			stmt.setLong(3, addFilm.getRelease_year());
			stmt.setInt(4, addFilm.getLanguage_id());
			stmt.setInt(5, addFilm.getRental_duration());
			stmt.setDouble(6, addFilm.getRental_rate());
			stmt.setInt(7, addFilm.getLength());
			stmt.setDouble(8, addFilm.getReplacement_cost());
			stmt.setString(9, addFilm.getRating());
//			ResultSet updateCount = stmt.executeQuery();

			int newKey = stmt.executeUpdate();

			addFilm.setId(newKey);
			newFilm = addFilm;

			// close connections
			conn.commit();
			conn.close();
			stmt.close();

		} catch (Exception e) {
		}

		return newFilm;

	}

	public boolean deleteFilm(Film film) {

		Connection conn = null;
		String sql = "DELETE FROM film WHERE id = ?";

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);

			stmt.setInt(1, film.getId());
			stmt.executeUpdate();
			conn.commit();

			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
				int language_id = filmResult.getInt("language_id");
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
			e.printStackTrace();
		}
		return film;
	}

	public boolean editFilm(Film film, int filmId) {
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			String sql = "UPDATE film SET title= ?, description=? ,release_year= ?, rental_duration=? rental_rate = ?, length = ?, replacement_cost = ?, rating =?, language_id= ?WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getRelease_year());
			stmt.setInt(4, film.getRental_duration());
			stmt.setDouble(5, film.getRental_rate());
			stmt.setInt(6, film.getLength());
			stmt.setDouble(7, film.getReplacement_cost());
			stmt.setString(8, film.getRating());
			stmt.setInt(9, film.getLanguage_id());
			stmt.setInt(10, film.getId());

			int newKey = stmt.executeUpdate();

		} catch (Exception e) {

		}

		return true;
	}

	@Override
	public List<Film> findFilmByKW(String keyword) {
		List<Film> filmList = new ArrayList<Film>();

		String sql = "SELECT * FROM film s WHERE title LIKE ? OR description LIKE ?";

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement ps = conn.prepareStatement(sql);

			// set parameter
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");

			ResultSet filmResult = ps.executeQuery();

			while (filmResult.next()) {
				int id = filmResult.getInt("id");
				String title = filmResult.getString("title");
				String description = filmResult.getString("description");
				int release_year = filmResult.getInt("release_year");
				int language_id = filmResult.getInt("language_id");
				int rental_duration = filmResult.getInt("rental_duration");
				double rental_rate = filmResult.getDouble("rental_rate");
				int length = filmResult.getInt("length");
				String rating = filmResult.getString("rating");
				double replacement_cost = filmResult.getDouble("replacement_cost");
				List<Actor> actors = new ArrayList<>();
				filmList.add(new Film(id, title, description, release_year, language_id, rental_duration, rental_rate,
						length, replacement_cost, rating, actors));

			}
			return filmList;

		} catch (SQLException e) {
			System.out.println("Cant find such film ");
			e.printStackTrace();
		} finally {
			return filmList;
		}

	}

//	@Override
//	public List<Film> findFilmByKW(String filmKW) {
//		// TODO Auto-generated method stub
//		return null;
//	}

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

}