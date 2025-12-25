package com.company.moviebooking.service;

import com.company.moviebooking.model.Movie;
import com.company.moviebooking.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // 🔹 Fetch all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
