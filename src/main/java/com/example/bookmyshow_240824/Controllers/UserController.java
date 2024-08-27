package com.example.bookmyshow_240824.Controllers;


import com.example.bookmyshow_240824.dtos.ResponseStatus;
import com.example.bookmyshow_240824.dtos.SignUpRequestDto;
import com.example.bookmyshow_240824.dtos.SignUpResponseDto;
import com.example.bookmyshow_240824.exceptions.UserAlreadyExistsException;
import com.example.bookmyshow_240824.models.User;
import com.example.bookmyshow_240824.services.UserService;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try {
            User user = userService.signUp(
                    signUpRequestDto.getName(),
                    signUpRequestDto.getEmail(),
                    signUpRequestDto.getPassword());

            signUpResponseDto.setName(user.getName());
            signUpResponseDto.setStatus(ResponseStatus.SUCCESS);
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
            signUpResponseDto.setStatus(ResponseStatus.FAILURE);
        }

        return signUpResponseDto;
    }
}