package com.example.bookmyshow_240824.dtos;

import lombok.Getter;
import lombok.Setter;

import lombok.AllArgsConstructor;

import java.util.List;



@Getter
@Setter
public class BookTicketRequestDto {
    private Long userId;
    private Long showId;
    List<Long> showSeatIds;
    public BookTicketRequestDto() {
    }

    public BookTicketRequestDto(Long userId, Long showId, List<Long> showSeatIds) {
        this.userId = userId;
        this.showId = showId;
        this.showSeatIds = showSeatIds;
    }
}