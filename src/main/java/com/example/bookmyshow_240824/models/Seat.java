package com.example.bookmyshow_240824.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    @ManyToOne
    public SeatType seatType;
    private int rowVal;
    private int colVal;

}
