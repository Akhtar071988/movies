package com.galvanize.service;

import com.galvanize.MovieRepository;
import com.galvanize.entity.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
