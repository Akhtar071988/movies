package com.galvanize.controller;

import com.galvanize.entity.Movie;
import com.galvanize.repository.MovieRepository;
import com.galvanize.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie input){
        return movieService.createMovie(input);
    }
}
