package com.galvanize.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movieid")
    private long movieId;
    @Column(name = "imdbid")
    private String imdbId;
    @Column(length = 50)
    private String actors;
    @Column(length = 50)
    private String director;
    @Column(length = 300)
    private String title;
    @Column(length = 10)
    private int year;
    @Column(length = 15)
    LocalDate released;

    public Movie(String imdbId, String director, String title, Integer year, LocalDate localDate) {
    }

    public Movie(long movieId, String imdbId, String actors, String director, String title, Integer year, LocalDate released){
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.actors = actors;
        this.director = director;
        this.title = title;
        this.year = year;
        this.released = released;
    }

    public Movie(String imdbId, String actors, String director, String title, Integer year, LocalDate released){
        this.imdbId = imdbId;
        this.actors = actors;
        this.director = director;
        this.title = title;
        this.year = year;
        this.released = released;
    }

    public Movie() {
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDate getLocalDate() {
        return released;
    }

    public void setLocalDate(LocalDate localDate) {
        this.released = released;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieId == movie.movieId &&
                Objects.equals(imdbId, movie.imdbId) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(released, movie.released);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, imdbId, actors, director, title, year, released);
    }

    public void update(Movie updateMovie){
        if(updateMovie.getImdbId()!=null)this.setImdbId(updateMovie.getImdbId());
        if(updateMovie.getActors()!=null)this.setActors(updateMovie.getActors());
        if(updateMovie.getMovieId()!=0)this.setMovieId(updateMovie.getMovieId());
        if(updateMovie.getDirector()!=null)this.setDirector(updateMovie.getDirector());
        if(updateMovie.getTitle()!=null)this.setTitle(updateMovie.getTitle());
        if(updateMovie.getYear()!=null)this.setYear(updateMovie.getYear());
        if(updateMovie.getLocalDate()!=null)this.setLocalDate(updateMovie.getLocalDate());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", imdbId='" + imdbId + '\'' +
                ", actors='" + actors + '\'' +
                ", director='" + director + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", released=" + released +
                '}';
    }
}
