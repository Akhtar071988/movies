package com.galvanize.controller;

import com.galvanize.entity.Movie;
import com.galvanize.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie input){
        return movieService.createMovie(input);
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/imdbId")
    public Movie getMoviesByimdbId(@RequestParam String imdbId){
        return movieService.findByImdbId(imdbId);
    }
}
