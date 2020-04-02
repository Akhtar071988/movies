package com.galvanize.service;

import com.galvanize.MovieRepository;
import com.galvanize.entity.Movie;
import org.springframework.stereotype.Service;

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
}
