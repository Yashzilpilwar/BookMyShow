package com.example.bookmyshow_240824.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private String name;
    private ResponseStatus status;
}
