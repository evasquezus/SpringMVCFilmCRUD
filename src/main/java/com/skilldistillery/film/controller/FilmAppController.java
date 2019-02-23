package com.skilldistillery.film.controller;

import java.util.ArrayList;
import java.util.List;
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

	@RequestMapping(path = "GetFilm.do", params = { "FilmId" }, method = RequestMethod.GET)
	public ModelAndView getFilmByID(@RequestParam("FilmId") int FilmID) {
		ModelAndView mv = new ModelAndView();
		Film filmSearched;
		try {
			filmSearched = dao.findFilmById(FilmID);
			mv.addObject("film", filmSearched);
			mv.setViewName("WEB-INF/views/diplayResults.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return mv;

	}

	@RequestMapping(path = "GetKeyword.do", method = RequestMethod.GET)
	public ModelAndView getFilmByID(String FilmKW) {
		ModelAndView mv = new ModelAndView();
		List<Film> filmByKW = new ArrayList<Film>();
		try {
			filmByKW = dao.findFilmByKW(FilmKW);
			mv.addObject("film", filmByKW);
			mv.setViewName("WEB-INF/views/diplayResults.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;

	}
}
