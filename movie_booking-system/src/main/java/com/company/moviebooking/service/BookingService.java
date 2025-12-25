package com.company.moviebooking.service;

import com.company.moviebooking.model.Booking;
import com.company.moviebooking.model.Seat;
import com.company.moviebooking.model.Show;
import com.company.moviebooking.model.User;
import com.company.moviebooking.repository.BookingRepository;
import com.company.moviebooking.repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;

    public BookingService(BookingRepository bookingRepository,
                          SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
    }

    public Booking book(User user, Show show, List<Seat> seats) {

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);

        // ✅ getPrice() now exists
        booking.setTotalAmount(seats.size() * show.getPrice());

        Booking savedBooking = bookingRepository.save(booking);

        for (Seat seat : seats) {

            if ("BOOKED".equals(seat.getStatus())) {
                throw new RuntimeException("Seat already booked");
            }

            seat.setStatus("BOOKED");

            // ✅ save() now resolves
            seatRepository.save(seat);
        }

        return savedBooking;
    }
}
