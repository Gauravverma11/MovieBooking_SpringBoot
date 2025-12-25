package com.company.moviebooking.controller;

import com.company.moviebooking.model.User;
import com.company.moviebooking.service.BookingService;
import com.company.moviebooking.service.ShowService;
import com.company.moviebooking.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final ShowService showService;
    private final UserService userService;

    public BookingController(BookingService bookingService,
                             ShowService showService,
                             UserService userService) {
        this.bookingService = bookingService;
        this.showService = showService;
        this.userService = userService;
    }

    @PostMapping("/book")
    public String book(@RequestParam Long showId,
                       @RequestParam List<Long> seatIds,
                       Principal principal) {

        User user = userService.getUserByEmail(principal.getName());
        bookingService.book(user, showService.getShowById(showId),
                showService.getSeatsByShow(showId));

        return "redirect:/movies";
    }
}
