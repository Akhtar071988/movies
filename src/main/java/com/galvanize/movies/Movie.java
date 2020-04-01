package com.galvanize.movies;

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
    @Column(name = "actors")
    private String actors;
    @Column(name = "director")
    private String diretor;
    @Column(name = "title")
    private String title;
    @Column(name = "year")
    private String year;
    @Column(name = "released")
    LocalDate localDate;

    public Movie() {
    }

    public Movie(long movieId, String imdbId, String actors, String director, String title, String year, LocalDate localDate){
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.actors = actors;
        this.diretor = director;
        this.title = title;
        this.year = year;
        this.localDate = localDate;
    }

    public Movie(String imdbId, String actors, String director, String title, String year, LocalDate localDate){
        this.imdbId = imdbId;
        this.actors = actors;
        this.diretor = director;
        this.title = title;
        this.year = year;
        this.localDate = localDate;
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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieId == movie.movieId &&
                Objects.equals(imdbId, movie.imdbId) &&
                Objects.equals(actors, movie.actors) &&
                Objects.equals(diretor, movie.diretor) &&
                Objects.equals(title, movie.title) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(localDate, movie.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, imdbId, actors, diretor, title, year, localDate);
    }

    public void update(Movie updateMovie){
        if(updateMovie.getImdbId()!=null)this.setImdbId(updateMovie.getImdbId());
        if(updateMovie.getActors()!=null)this.setActors(updateMovie.getActors());
        if(updateMovie.getMovieId()!=0)this.setMovieId(updateMovie.getMovieId());
        if(updateMovie.getDiretor()!=null)this.setDiretor(updateMovie.getDiretor());
        if(updateMovie.getTitle()!=null)this.setTitle(updateMovie.getTitle());
        if(updateMovie.getYear()!=null)this.setYear(updateMovie.getYear());
        if(updateMovie.getLocalDate()!=null)this.setLocalDate(updateMovie.getLocalDate());
    }
}
