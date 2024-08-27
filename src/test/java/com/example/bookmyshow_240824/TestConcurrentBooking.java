package com.example.bookmyshow_240824;

import com.example.bookmyshow_240824.Controllers.BookingController;
import com.example.bookmyshow_240824.dtos.BookTicketRequestDto;
import com.example.bookmyshow_240824.dtos.BookTicketResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootTest
public class TestConcurrentBooking {
    static class ThreadResult{
        private final String threadName;
        private final BookTicketResponseDto bookTicketResponseDto;

        public ThreadResult(String threadName, BookTicketResponseDto bookTicketResponseDto) {
            this.threadName = threadName;
            this.bookTicketResponseDto = bookTicketResponseDto;
        }
    }

    @Autowired
    BookingController bookingController;

    @Test
    void testConcurrentBooking() {
        // Write your test case here
        Long userId = 2L, showId = 2L;
        List<Long> bookingSeats = List.of(26L, 27L);

        int numberOfThreads = 5;

        ExecutorService executorService = Executors.newFixedThreadPool((numberOfThreads));
        List<Future<ThreadResult>> futureBookings = new ArrayList<>();
        for (int i=0; i<numberOfThreads; i++) {
            Callable<ThreadResult> task = () -> {
                BookTicketResponseDto bookTicketResponseDto = bookingController.bookTicket(
                        new BookTicketRequestDto(userId, showId, bookingSeats));
                String threadName = Thread.currentThread().getName();
                return new ThreadResult(threadName, bookTicketResponseDto);
            };
            futureBookings.add(executorService.submit(task));
        }

        System.out.println("Clients booking details :");
        for (Future<ThreadResult> futureBooking : futureBookings) {
            try {
                ThreadResult threadResult = futureBooking.get();
                System.out.println("Thread Name: " + threadResult.threadName);
                System.out.println("Booking Reference: " + threadResult.bookTicketResponseDto.getBooking());
                System.out.println("Seats Blocked status: " + threadResult.bookTicketResponseDto.getStatus());
                System.out.println("##########################");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
