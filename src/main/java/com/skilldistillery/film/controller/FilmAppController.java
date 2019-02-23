package com.skilldistillery.film.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.database.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmAppController {
	@Autowired
	private FilmDAO dao;

	@RequestMapping("home.do")
	public String mainMenu() {
		return "WEB-INF/views/home.jsp";
	}

	@RequestMapping(path = "GetFilm.do", params = { "filmID" })
	public ModelAndView getFilmByID(int filmID) {
		ModelAndView mv = new ModelAndView();
		List<Film> filmList = new ArrayList<Film>();
		try {
			Film filmSearched = dao.findFilmById(filmID);
			filmList.add(filmSearched);
			mv.addObject("film", filmList);
			mv.setViewName("WEB-INF/views/diplayResults.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;

	}

//	@RequestMapping(path = "GetKeyword.do")
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
