package com.skilldistillery.film.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.database.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmAppController {
	Scanner input = new Scanner(System.in);

	@Autowired
	private FilmDAO dao;

	@RequestMapping(path = "GetFilm.do", params = { "filmID" }, method = RequestMethod.GET)
	public ModelAndView getFilmByID(@RequestParam("filmID") int filmID) {
		ModelAndView mv = new ModelAndView();
		Film filmSearched;
		try {
			filmSearched = dao.findFilmById(filmID);
			mv.addObject("film", filmSearched);
			mv.setViewName("WEB-INF/views/diplayResults.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return mv;
	}

	@RequestMapping(path = "GetKeyword.do", params = { "filmKW" }, method = RequestMethod.GET)
	public ModelAndView getFilmByKW(String filmKW) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = new ArrayList<Film>();
		try {
			films = dao.findFilmByKW(filmKW);
			System.out.println(films.toString());
			mv.addObject("filmList", films);
			mv.setViewName("WEB-INF/views/diplayResultsKW.jsp");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;

	}

	@RequestMapping(path = "deleteFilm.do", params = { "filmID" }, method = RequestMethod.POST)
	public ModelAndView deleteFilm(int filmId) throws SQLException {
		ModelAndView mv = new ModelAndView();
		boolean filmRemvoved = dao.deleteFilm(filmId);
		mv.addObject("filmRemoved", filmRemvoved);
		mv.setViewName("WEB-INF/views/diplayResultsOfDelete.jsp");
		if (!filmRemvoved) {
			return null;
		}
		return mv;
	}

}

// { "id", "second" },
//	@RequestMapping(path = "AddFilm.do", params = { "title", "description", "release_year", "replacement_cost", "rating" }, method = RequestMethod.POST)
//	public ModelAndView addFilm(Film film) {
//		ModelAndView mv = new ModelAndView();
//		dao.addFilm(film);
//		try {
//			mv.addObject("film", film);
//			mv.setViewName("WEB-INF/views/diplayResults.jsp");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			return mv;
//		}
//
//	}
