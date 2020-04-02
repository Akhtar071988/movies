package com.galvanize.service;

import com.galvanize.MovieRepository;
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
        Movie movie = new Movie("tt0241527", "Emma Watson", "Chris Columbus", "Harry Potter and the Sorcerer's Stone", "2001", LocalDate.of(2001, 11, 16));
        Movie expected = new Movie(1L, "tt0241527", "Emma Watson", "Chris Columbus", "Harry Potter and the Sorcerer's Stone", "2001", LocalDate.of(2001, 11, 16));
        when(movieRepository.save(any(Movie.class))).thenReturn(expected);
        assertEquals(expected, movieService.createMovie(movie));
    }
}
