package com.example.bookmyshow_240824.services;

import com.example.bookmyshow_240824.models.Show;
import com.example.bookmyshow_240824.models.ShowSeat;
import com.example.bookmyshow_240824.models.ShowSeatType;
import com.example.bookmyshow_240824.repositories.ShowSeatTypeRepository;
import com.example.bookmyshow_240824.repositories.ShowSeatRepository;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }


    public int calculatePrice(List<ShowSeat> showSeats, Show show) {
        /*
        1. Find all the show seat types for the given show
        e.g: Gold - 500, Silver - 300, Platinum - 700
        2. Iterate through all seats and match the seat type with all the available show seat types
        3. Add the price if the show seat type matches

         */
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        int totalPrice = 0;

        for (ShowSeat showSeat : showSeats) {
            for (ShowSeatType showSeatType : showSeatTypes) {
                if (showSeat.getSeat().getSeatType().getType().equals(showSeatType.getSeatType().getType())) {
                    totalPrice += showSeatType.getPrice();
                    break;
                }
            }
        }
        return totalPrice;
    }
}
