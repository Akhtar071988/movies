package com.galvanize.service;

import com.galvanize.MovieRepository;
import com.galvanize.entity.Movie;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    public Movie findByImdbId(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }

    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public Movie update(String imdbId, String director, String title, Integer year, LocalDate released){
        Movie existing = movieRepository.findById();
    }

//    public Joke update(long jokeId, Joke updateJoke) {
//        Joke preUpdateJoke = jpaJokeRepository.findById(jokeId).orElse(null);
//        if(preUpdateJoke==null)return null;
//        preUpdateJoke.update(updateJoke);
//        return preUpdateJoke;
//    }

    public boolean deleteById (long movieId){
        return movieRepository.deleteById(movieId);
    }
}
