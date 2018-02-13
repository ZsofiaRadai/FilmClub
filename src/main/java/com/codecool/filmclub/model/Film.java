package com.codecool.filmclub.model;

public class Film {

    private String imdbID;
    private String Title;
    private String year;
    private String type;
    private String poster;

    private char rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private float imdbRating;

    public Film() {

    }

    public Film(String title, String year, String imdbID, String type, String poster) {
        this.Title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
    }

    public Film(String imdbID, String title, String year, String type, String poster, char rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, float imdbRating) {
        this(title, year, imdbID, type, poster);
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.imdbRating = imdbRating;
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPoster() {
        return poster;
    }
}
