package com.codecool.filmclub.controller;

import com.codecool.filmclub.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchControl {

    @Autowired
    MovieService movieService;

    @GetMapping (value = "/")
    public String renderIndex(Model model) {
        return "index";
    }


    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public String renderFilms(@RequestParam("title") String title) {
        String resultList = movieService.searchMovie(title);
        System.out.println(resultList);
        System.out.println(resultList.getClass());
        return resultList;
    }

    @GetMapping(value = "/movies/{imdbID}")
    public String renderMovieDetails(Model model, @PathVariable("imdbID") String imdbID) {
        String result = movieService.getMovieDetails(imdbID);
        return result;
    }
}
