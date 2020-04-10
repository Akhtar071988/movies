package com.galvanize.repository;

import com.galvanize.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByImdbId(String imdbId);
    //Movie findTwoMoviesByImdbId(String imdbId);
    Movie findAllMoviesByTitle(String title);
    boolean deleteById(long movieId);
}
