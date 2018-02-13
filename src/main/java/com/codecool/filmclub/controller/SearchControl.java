package com.codecool.filmclub.controller;

import com.codecool.filmclub.model.Film;
import com.codecool.filmclub.service.FilmService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SearchControl {

    @Autowired
    FilmService filmService;

    @GetMapping (value = "/")
    public String renderIndex(Model model) {
        return "index";
    }


    @RequestMapping (value = "/search")
    public String renderFilms(Model model, @RequestParam("title") String title) {
        JsonObject resultList = filmService.searchFilm(title);
        List<String> posters = filmService.getPosters(resultList);
        List<Film> filmList = filmService.convertJsonToJavaObject(resultList);
        model.addAttribute("movieList", filmList);
        return "search-results";
    }
}
