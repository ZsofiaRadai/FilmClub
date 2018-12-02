package com.codecool.filmclub.model;

public class Movie {

    private String imdbID;
    private String Title;
    private String Year;
    private String Type;
    private String Poster;

    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private float imdbRating;

    public Movie(String title, String year, String imdbID, String type, String poster) {
        this.Title = title;
        this.Year = year;
        this.imdbID = imdbID;
        this.Type = type;
        this.Poster = poster;
    }

    public Movie(String imdbID, String title, String year, String type, String poster, String rated, String released, String runtime, String genre, String director, String writer, String actors, String plot, String language, String country, float imdbRating) {
        this(title, year, imdbID, type, poster);
        this.Rated = rated;
        this.Released = released;
        this.Runtime = runtime;
        this.Genre = genre;
        this.Director = director;
        this.Writer = writer;
        this.Actors = actors;
        this.Plot = plot;
        this.Language = language;
        this.Country = country;
        this.imdbRating = imdbRating;
    }

    public String getRated() {
        return Rated;
    }

    public String getReleased() {
        return Released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public String getDirector() {
        return Director;
    }

    public String getWriter() {
        return Writer;
    }

    public String getActors() {
        return Actors;
    }

    public String getPlot() {
        return Plot;
    }

    public String getLanguage() {
        return Language;
    }

    public String getCountry() {
        return Country;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return Type;
    }

    public String getPoster() {
        return Poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + imdbID +
                ", title='" + Title + '\'' +
                ", year='" + Year + '\'' +
                ", director='" + Director + '\'' +
                ", actors='" + Actors + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                '}';
    }
}
