package com.example.bookmyshow_240824.repositories;

import com.example.bookmyshow_240824.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Override
    List<Booking> findAllById(Iterable<Long> ids);
}
