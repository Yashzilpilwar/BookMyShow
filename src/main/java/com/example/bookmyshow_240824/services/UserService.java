package com.example.bookmyshow_240824.services;

import com.example.bookmyshow_240824.models.User;
import com.example.bookmyshow_240824.repositories.UserRepository;
import com.example.bookmyshow_240824.exceptions.UserAlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Optional;


@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signUp(String name,
                       String email,
                       String password) throws UserAlreadyExistsException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
            // Move to the login flow
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }
}
