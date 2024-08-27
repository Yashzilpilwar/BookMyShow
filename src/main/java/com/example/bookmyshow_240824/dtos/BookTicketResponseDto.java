package com.example.bookmyshow_240824.dtos;


import com.example.bookmyshow_240824.models.Booking;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class BookTicketResponseDto {
    private Booking booking;
    private ResponseStatus status;
}