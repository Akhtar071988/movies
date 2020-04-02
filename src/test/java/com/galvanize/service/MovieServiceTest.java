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
        assertEquals(expected, movieService.findByImdbId("tt0241527"));
    }

    @Test
    public void getMovieByTitle(){
        Movie expected = new Movie(1L, "tt0241527", "Emma Watson", "Chris Columbus", "Harry Potter and the Sorcerer's Stone", 2001, LocalDate.of(2001, 11, 16));
        when(movieRepository.findByTitle(anyString())).thenReturn(expected);
        assertEquals(expected, movieService.findByTitle("Harry Potter and the Sorcerer's Stone"));
    }

    @Test
    public void updateMovie(){
        MovieService movieService = new MovieService(movieRepository);
        Movie expected = movieService.createMovie(new Movie("tt0926084", "Emma Watson", "David Yates", "Harry Potter and the Deathly Hallows: Part 1", 2010, LocalDate.of(2010, 11, 19)));
        when(movieService.findByImdbId(anyString())).thenReturn(expected);
        assertEquals(expected, movieService.findByImdbId("tt0926084"));
    }

    @Test
    public void deleteMovie(){
        when(movieRepository.deleteById(anyLong())).thenReturn(true);
        assertTrue(movieService.deleteById(1L));
    }
}
