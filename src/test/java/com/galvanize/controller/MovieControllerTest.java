package com.galvanize.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.entity.Movie;
import com.galvanize.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MovieControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    MovieService movieService;
    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void createMovie() throws Exception {
        Movie expected = new Movie();
        String json = objectMapper.writeValueAsString(expected);
        expected.setMovieId(1L);
        when(movieService.createMovie(any(Movie.class))).thenReturn(expected);
        mvc.perform(post("/api/movies").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movieId").value(expected.getMovieId()));

    }

    @Test
    public void getAllMovies() throws Exception {
        Movie expected = new Movie();
        expected.setMovieId(1L);
        ArrayList<Movie> movie = new ArrayList<>();
        movie.add(expected);
        when(movieService.getAllMovies()).thenReturn(movie);
        mvc.perform(get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].movieId").value(expected.getMovieId()));
    }

    @Test
    public void getMovieByimdbId() throws Exception {
        Movie expected = new Movie();
        expected.setMovieId(1L);
        when(movieService.findMovieByImdbId("tt0241527")).thenReturn(expected);
        mvc.perform(get("/api/movies/imdbId/tt0241527"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imdbId").value(expected.getImdbId()))
                .andExpect(jsonPath("$.movieId").value(expected.getMovieId()));
    }

    @Test
    public void getMovieByimdbIdQuery() throws Exception {
        Movie expected = new Movie();
        expected.setMovieId(1L);
        when(movieService.findMovieByImdbId("tt0241527")).thenReturn(expected);
        mvc.perform(get("/api/movies/imdb?imdbId=tt0241527"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.imdbId").value(expected.getImdbId()))
                .andExpect(jsonPath("$.movieId").value(expected.getMovieId()));
    }

    @Test
    public void getAllMoviesByTitle() throws Exception {
        Movie expected = new Movie();
        expected.setMovieId(1L);
        when(movieService.findAllMoviesByTitle("Harry Potter and the Sorcerer's Stone")).thenReturn(expected);
        mvc.perform(get("/api/movies/title/Harry Potter and the Sorcerer's Stone"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(expected.getTitle()))
                .andExpect(jsonPath("$.movieId").value(expected.getMovieId()));
    }

    @Test
    public void deleteMovieById() throws Exception {
        when(movieService.deleteById(anyLong())).thenReturn(true);
        mvc.perform(delete("/api/movies/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(true));
    }

//    @Test
//    public void updateMovie() throws Exception {
//        Movie expected = new Movie();
//        expected.setMovieId(1L);
//        String json = objectMapper.writeValueAsString(expected);
//        when(movieService.updateMovieWithStarRating(anyLong(), any(Movie.class))).thenReturn(expected);
//        mvc.perform(put("/api/movies/rating/1").content(json).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.movieId").value(expected.getMovieId()));
//    }
}
