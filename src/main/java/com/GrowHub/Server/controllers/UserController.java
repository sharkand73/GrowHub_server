package com.GrowHub.Server.controllers;

import com.GrowHub.Server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }

}
