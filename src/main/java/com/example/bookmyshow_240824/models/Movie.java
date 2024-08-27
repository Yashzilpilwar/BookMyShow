package com.example.bookmyshow_240824.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    @OneToMany
    private List<Actor> actors;
    private double duration;

}
