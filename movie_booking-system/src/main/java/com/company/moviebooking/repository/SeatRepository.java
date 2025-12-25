package com.company.moviebooking.repository;

import com.company.moviebooking.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    // ✅ REQUIRED for ShowService
    List<Seat> findByShowId(Long showId);
}
