package com.example.bookmyshow_240824.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private int price;

}
