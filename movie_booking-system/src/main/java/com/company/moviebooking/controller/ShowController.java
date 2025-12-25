package com.company.moviebooking.controller;

import com.company.moviebooking.service.ShowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/shows/{movieId}")
    public String shows(@PathVariable Long movieId, Model model) {
        model.addAttribute("shows", showService.getShowsByMovie(movieId));
        return "shows";
    }

    @GetMapping("/seats/{showId}")
    public String seats(@PathVariable Long showId, Model model) {
        model.addAttribute("seats", showService.getSeatsByShow(showId));
        model.addAttribute("showId", showId);
        return "seats";
    }
}
