package com.galvanize.service;

import com.galvanize.repository.MovieRepository;
import com.galvanize.entity.Movie;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
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


    public Movie findMovieByImdbId(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }

    public Movie findAllMoviesByTitle(String title) {
        return movieRepository.findAllMoviesByTitle(title);
    }

    public Movie updateMovieWithStarRating(Integer rating, Movie updateMovieWithStarRating) {
        Movie newMovie = updateMovieWithStarRating(rating, updateMovieWithStarRating);
        newMovie.update(newMovie);
        return  createMovie(newMovie);
    }

    public boolean deleteById (long movieId){
        return movieRepository.deleteById(movieId);
    }
}
