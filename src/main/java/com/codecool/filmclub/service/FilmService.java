package com.codecool.filmclub.service;

import com.codecool.filmclub.model.Film;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    private final String OMDB_URL = "http://www.omdbapi.com/?apikey=ac3c14bf&s=";

    public JsonObject searchFilm(String title) {

        final String URI = OMDB_URL + title;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(URI, String.class);
        JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
        return jsonObject;
    }

    public List<Film> convertJsonToJavaObject(JsonObject jsonObject) {
        List<Film> filmObjectList = new ArrayList<>();
        JsonArray filmJsonArray = jsonObject.get("Search").getAsJsonArray();
        for (JsonElement film: filmJsonArray) {
            String title = film.getAsJsonObject().get("Title").getAsString();
            String year = film.getAsJsonObject().get("Year").getAsString();
            String imdbID = film.getAsJsonObject().get("imdbID").getAsString();
            String type = film.getAsJsonObject().get("Type").getAsString();
            String poster = film.getAsJsonObject().get("Poster").getAsString();
            Film newFilm = new Film(title, year, imdbID, type, poster);
            filmObjectList.add(newFilm);
        }
        return filmObjectList;
    }
}
