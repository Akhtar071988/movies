package com.galvanize.service;

import com.galvanize.repository.MovieRepository;
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

    public Movie findAllMoviesByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public Movie updateMovieWithStarRating(Integer rating) {
        Movie newMovie = updateMovieWithStarRating(rating);
        newMovie.update(newMovie);
        return  createMovie(newMovie);
    }

    public boolean deleteById (long movieId){
        return movieRepository.deleteById(movieId);
    }
}
