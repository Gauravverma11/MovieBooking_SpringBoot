package com.company.moviebooking.repository;

import com.company.moviebooking.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    // movie ke saare shows
    List<Show> findByMovieId(Long movieId);
}
