package com.example.bookmyshow_240824;

import com.example.bookmyshow_240824.Controllers.BookingController;
import com.example.bookmyshow_240824.dtos.BookTicketRequestDto;
import com.example.bookmyshow_240824.dtos.BookTicketResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestBookTicket {
    @Autowired
    BookingController bookingController;

    @Test
    void testBooking() {
        BookTicketRequestDto bookTicketRequestDto = new BookTicketRequestDto();
        bookTicketRequestDto.setUserId(2L);
        bookTicketRequestDto.setShowId(1L);
        bookTicketRequestDto.setShowSeatIds(List.of(16L, 17L));

        BookTicketResponseDto bookTicketResponseDto = bookingController.bookTicket(bookTicketRequestDto);
        System.out.println("Booking Reference: "+ bookTicketResponseDto.getBooking());
        System.out.println("Seats Blocked status: "+ bookTicketResponseDto.getStatus());
    }
}
