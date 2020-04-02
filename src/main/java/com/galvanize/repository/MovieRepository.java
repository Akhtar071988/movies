package com.galvanize.repository;

import com.galvanize.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByImdbId(String imdbId);
    Movie findByTitle(String title);
    boolean deleteById(long movieId);
}
