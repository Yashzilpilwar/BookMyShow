package com.example.bookmyshow_240824;


import com.example.bookmyshow_240824.Controllers.UserController;
import com.example.bookmyshow_240824.dtos.SignUpRequestDto;
import com.example.bookmyshow_240824.dtos.SignUpResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;







@SpringBootTest
class Bookmyshow240824ApplicationTests {

    @Autowired
    private UserController userController;
    @Test
    void contextLoads() {
    }

    @Test
    void testUser() {
        SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
        signUpRequestDto.setName("Souvik");
        signUpRequestDto.setEmail("sm@x.com");
        signUpRequestDto.setPassword("123456");

        SignUpResponseDto signUpResponseDto = userController.signUp(signUpRequestDto);
        System.out.println(signUpResponseDto.getName());
        System.out.println(signUpResponseDto.getStatus());
    }

}
