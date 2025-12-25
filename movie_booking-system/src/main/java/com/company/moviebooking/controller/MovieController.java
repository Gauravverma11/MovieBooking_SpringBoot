package com.company.moviebooking.controller;

import com.company.moviebooking.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies";
    }
}
