package com.company.moviebooking.service;

import com.company.moviebooking.model.Seat;
import com.company.moviebooking.model.Show;
import com.company.moviebooking.repository.SeatRepository;
import com.company.moviebooking.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;

    public ShowService(ShowRepository showRepository,
                       SeatRepository seatRepository) {
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
    }

    // 🔹 Movie ke saare shows
    public List<Show> getShowsByMovie(Long movieId) {
        return showRepository.findByMovieId(movieId);
    }

    // 🔹 Show ke saare seats
    public List<Seat> getSeatsByShow(Long showId) {
        return seatRepository.findByShowId(showId);
    }

    // 🔹 Single show
    public Show getShowById(Long showId) {
        return showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));
    }
}