package com.skilldistillery.film.controller;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.database.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmAppController {
	Scanner input = new Scanner(System.in);

	@Autowired
	private FilmDAO dao;

	@RequestMapping("/")
	public String mainMenu() {
		return "WEB-INF/views/diplayResults.jsp";
	}

	@RequestMapping("home.do")
	public String mainMenu1() {
		return "WEB-INF/views/home.jsp";
	}

	@SuppressWarnings("finally")
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
			return mv;
		}

	}

	@SuppressWarnings("finally")
	@RequestMapping(path = "AddFilm.do", params = { "title", "description", "release_year", "language_id",
			"rental_duration", "rental_rate", "length", "replacement_cost", "rating" }, method = RequestMethod.POST)
	public ModelAndView addFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		dao.addFilm(film);
		try {
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/views/diplayAddFilm.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return mv;
		}

	}

	@SuppressWarnings("finally")
	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam(value = "filmID") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/displayResultsOfDelete.jsp");
		try {
			boolean test = dao.deleteFilm(dao.findFilmById(id));
			mv.addObject("test", test);
			System.out.println("AM I HERE");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;

	}

//	@RequestMapping(path = "GetKeyword.do", method = RequestMethod.GET)
//	public ModelAndView getFilmByID(String FilmKW) {
//		ModelAndView mv = new ModelAndView();
//		List<Film> filmByKW = new ArrayList<Film>();
//		try {
//			filmByKW = dao.findFilmByKW(FilmKW);
//			mv.addObject("film", filmByKW);
//			mv.setViewName("WEB-INF/views/diplayResults.jsp");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return mv;
//
//	}
}
