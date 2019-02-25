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
	public ModelAndView getFilmByKW(@RequestParam("filmkW") String filmKW) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = new ArrayList<Film>();
		try {
			films = dao.findFilmByKW(filmKW);
			System.out.println(films.toString());
			mv.addObject("film", films);
			mv.setViewName("WEB-INF/views/diplayResultsKW.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;

	}

	@RequestMapping(path = "deleteFilm.do", params = { "filmID" }, method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam("filmID") int filmId) throws SQLException {
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
