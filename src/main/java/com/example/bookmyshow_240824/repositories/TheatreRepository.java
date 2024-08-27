package com.example.bookmyshow_240824.repositories;

import com.example.bookmyshow_240824.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
}
