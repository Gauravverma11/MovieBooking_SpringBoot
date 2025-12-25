package com.company.moviebooking.repository;

import com.company.moviebooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // future: user ki booking history
}
