package com.example.bookmyshow_240824.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    private String bookingReference;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User user;
    private int amount;
    @OneToMany
    private List<Payment> payments;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @Override
    public String toString() {
        return "Booking Reference: " + bookingReference + "\n" +
                "Show Seats: " + showSeats + "\n" +
                "User Name: " + user.getName() + "\n" +
                "User Email: " + user.getEmail() + "\n" +
                "Amount: " + amount + "\n" +
                "Booking Status: " + bookingStatus;
    }
}

/*

User : Booking
1 : M
1 : 1

Enum: Integer Value (Ordinal) : String (String)

 */