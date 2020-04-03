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

    @GetMapping("/imdbId/{imdbId}")
    public Movie getMoviesByimdbId(@PathVariable String imdbId){
        return movieService.findMovieByImdbId(imdbId);
    }

    @GetMapping("/imdb")
    public Movie getMoviesByimdbQuery(@RequestParam String imdbId){
        return movieService.findMovieByImdbId(imdbId);
    }

    @GetMapping("/title/{title}")
    public Movie getAllMoviesByTitle(@PathVariable String title){
        return movieService.findAllMoviesByTitle(title);
    }

    @DeleteMapping("/{id}")
    public boolean updateMovie(@PathVariable long id){
        return movieService.deleteById(id);
    }

    @PatchMapping("/{movieId}")
    public Movie updateMovie(@PathVariable long movieId, @RequestBody Integer rating){
        return movieService.updateMovieWithStarRating(movieId, rating);
    }
}
