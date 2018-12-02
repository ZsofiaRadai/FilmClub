package com.codecool.filmclub.service;

import com.codecool.filmclub.model.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {

    private final String OMDB_URL = "http://www.omdbapi.com/?apikey=ac3c14bf&";

    public String searchMovie(String title) {
        String URI = OMDB_URL + "s=" + title;
        String response = omdbSearch(URI);
        return response;
    }

    public String getMovieDetails(String imdbID) {
        String URI = OMDB_URL + "i=" + imdbID;
        String response = omdbSearch(URI);
        return response;
    }

    public String omdbSearch(String URI) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        String response = restTemplate.getForObject(URI, String.class);
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return response;
    }

    public List<Movie> convertJsonToJavaObject(JsonObject jsonObject) {
        List<Movie> movieObjectList = new ArrayList<>();
        JsonArray filmJsonArray = jsonObject.get("Search").getAsJsonArray();
        for (JsonElement film: filmJsonArray) {
            String title = film.getAsJsonObject().get("Title").getAsString();
            String year = film.getAsJsonObject().get("Year").getAsString();
            String imdbID = film.getAsJsonObject().get("imdbID").getAsString();
            String type = film.getAsJsonObject().get("Type").getAsString();
            String poster = film.getAsJsonObject().get("Poster").getAsString();
            if (poster.equals("N/A")) {
                poster = null;
            }
            Movie newMovie = new Movie(title, year, imdbID, type, poster);
            movieObjectList.add(newMovie);
        }
        return movieObjectList;
    }

    public Movie convertJsonMovieToJavaMovie(JsonObject jsonObject) {
        Gson gson = new Gson();
        Movie movie = gson.fromJson(jsonObject, Movie.class);
        return movie;
    }
}
