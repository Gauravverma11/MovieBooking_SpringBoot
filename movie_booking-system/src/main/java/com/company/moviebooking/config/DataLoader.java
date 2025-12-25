package com.company.moviebooking.config;

import com.company.moviebooking.model.*;
import com.company.moviebooking.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final MovieRepository movieRepo;
    private final ShowRepository showRepo;
    private final SeatRepository seatRepo;

    public DataLoader(MovieRepository movieRepo,
                      ShowRepository showRepo,
                      SeatRepository seatRepo) {
        this.movieRepo = movieRepo;
        this.showRepo = showRepo;
        this.seatRepo = seatRepo;
    }

    @Override
    public void run(String... args) {
        if (movieRepo.count() == 0) {
            Movie m = new Movie();
            m.setTitle("Avengers");
            m.setLanguage("English");
            m.setDuration(180);
            m.setRating(8.5);
            movieRepo.save(m);

            Show s = new Show();
            s.setMovie(m);
            s.setScreenName("Screen 1");
            s.setPrice(200);
            s.setShowDate(LocalDate.now());
            s.setShowTime(LocalTime.of(19, 0));
            showRepo.save(s);

            for (int i = 1; i <= 10; i++) {
                Seat seat = new Seat();
                seat.setSeatNumber("A" + i);
                seat.setShow(s);
                seatRepo.save(seat);
            }
        }
    }
}
