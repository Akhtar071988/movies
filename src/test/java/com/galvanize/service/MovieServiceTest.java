package com.galvanize.service;

import com.galvanize.repository.MovieRepository;
import com.galvanize.entity.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MovieServiceTest {

    @MockBean
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;

    @Test
    public void createMovie(){
        Movie movie = new Movie("tt0241527", "Emma Watson", "Chris Columbus", "Harry Potter and the Sorcerer's Stone", 2001, LocalDate.of(2001, 11, 16));
        Movie expected = new Movie(1L, "tt0241527", "Emma Watson", "Chris Columbus", "Harry Potter and the Sorcerer's Stone", 2001, LocalDate.of(2001, 11, 16));
        when(movieRepository.save(any(Movie.class))).thenReturn(expected);
        assertEquals(expected, movieService.createMovie(movie));
    }

    @Test
    public void getAllMovies(){
        Movie expected = new Movie(1L, "tt0241527", "Emma Watson", "Chris Columbus", "Harry Potter and the Sorcerer's Stone", 2001, LocalDate.of(2001, 11, 16));
        ArrayList<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(expected);
        when(movieRepository.findAll()).thenReturn(expectedMovies);
        assertEquals(expectedMovies, movieService.getAllMovies());
    }

    @Test
    public void getMovieByImdbId(){
        Movie expected = new Movie(1L, "tt0241527", "Emma Watson", "Chris Columbus", "Harry Potter and the Sorcerer's Stone", 2001, LocalDate.of(2001, 11, 16));
        when(movieRepository.findByImdbId(anyString())).thenReturn(expected);
        assertEquals(expected, movieService.findMovieByImdbId("tt0241527"));
    }

    @Test
    public void getAllMoviesByTitle(){
        Movie expected = new Movie(1L, "tt0241527", "Emma Watson", "Chris Columbus", "Harry Potter and the Sorcerer's Stone", 2001, LocalDate.of(2001, 11, 16));
        when(movieRepository.findAllMoviesByTitle(anyString())).thenReturn(expected);
        assertEquals(expected, movieService.findAllMoviesByTitle("Harry Potter and the Sorcerer's Stone"));
    }

    @Test
    public void updateMovieWithStarRating(){
        MovieService movieService = new MovieService(movieRepository);
        Movie expected = movieService.createMovie(new Movie(1L, "tt0241527", "Emma Watson", "Chris Columbus", "Harry Potter and the Sorcerer's Stone", 4, 2001, LocalDate.of(2001, 11, 16)));
        when(movieService.findMovieByImdbId(anyString())).thenReturn(expected);
        assertEquals(expected, movieService.findMovieByImdbId("tt0926084"));
    }

    @Test
    public void deleteMovie(){
        when(movieRepository.deleteById(anyLong())).thenReturn(true);
        assertTrue(movieService.deleteById(1L));
    }
}
