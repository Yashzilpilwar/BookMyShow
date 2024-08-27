package com.example.bookmyshow_240824.Controllers;

import com.example.bookmyshow_240824.models.Booking;
import com.example.bookmyshow_240824.services.BookingService;
import com.example.bookmyshow_240824.dtos.BookTicketRequestDto;
import com.example.bookmyshow_240824.dtos.BookTicketResponseDto;
import com.example.bookmyshow_240824.dtos.ResponseStatus;
import org.springframework.stereotype.Controller;


@Controller
public class BookingController {


    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
        System.out.println("Booking ticket");
        BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
        try {
            Booking booking = bookingService.bookTicket(
                    bookTicketRequestDto.getUserId(),
                    bookTicketRequestDto.getShowId(),
                    bookTicketRequestDto.getShowSeatIds()
            );

            bookTicketResponseDto.setBooking(booking);
            bookTicketResponseDto.setStatus(ResponseStatus.SUCCESS);
            return bookTicketResponseDto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            bookTicketResponseDto.setStatus(ResponseStatus.FAILURE);
        }
        return bookTicketResponseDto;
    }
}
