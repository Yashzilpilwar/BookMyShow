package com.example.bookmyshow_240824.dtos;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
    private String name;
    private String email;
    private String password;
}
