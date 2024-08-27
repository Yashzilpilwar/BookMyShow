package com.example.bookmyshow_240824.services;

import com.example.bookmyshow_240824.exceptions.ShowNotFoundException;
import com.example.bookmyshow_240824.exceptions.UserNotFoundException;
import com.example.bookmyshow_240824.models.*;
import com.example.bookmyshow_240824.repositories.BookingRepository;
import com.example.bookmyshow_240824.repositories.ShowRepository;
import com.example.bookmyshow_240824.repositories.ShowSeatRepository;
import com.example.bookmyshow_240824.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }

    public Booking bookTicket(Long userId,
                              Long showId,
                              List<Long> showSeatIds)
            throws UserNotFoundException, ShowNotFoundException {
        /*
        1. Get the user by userId
        2. Get the show by showId
        3. Get the showSeats by showSeatIds
        4. Check if all the showSeats are available
        a. if available, proceed with booking
        b. if not available, throw an exception
        5. Change the status of the showSeats to BLOCKED
        6. Create the booking and move to payment page
         */

        // 1. Get the user by userId
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id: " + userId + " not found");
        }

        User user = optionalUser.get();

        // 2. Get the show by showId
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()) {
            throw new ShowNotFoundException("Show with id: " + showId + " not found");
        }
        Show show = optionalShow.get();

        // 3. Get the showSeats by showSeatIds
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        // 4. Check if all the showSeats are available
        for (ShowSeat showSeat : showSeats) {
            if(!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new RuntimeException("ShowSeat with id: " + showSeat.getId() + " not available");
            }
        }

        // 5. Change the status of the showSeats to BLOCKED
        for (ShowSeat showSeat : showSeats) {
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        // 6. Create the booking and move to payment page
        Booking booking = new Booking();
        booking.setUser(user);;
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(0);
        booking.setBookingReference("ABC123");
        return bookingRepository.save(booking);
    }
}
