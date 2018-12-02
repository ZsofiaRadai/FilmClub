package com.codecool.filmclub.controller;

import com.codecool.filmclub.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchControl {

    @Autowired
    MovieService movieService;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> renderFilms(@RequestParam("title") String title) {
        String resultList = movieService.searchMovie(title);
        return new ResponseEntity<String>(resultList, HttpStatus.OK);
    }

    @GetMapping(value = "/movies/{imdbID}")
    public ResponseEntity<String> renderMovieDetails(@PathVariable("imdbID") String imdbID) {
        String result = movieService.getMovieDetails(imdbID);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
