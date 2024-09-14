package com.alntech.appointments.controller;


import com.alntech.appointments.controller.RequestBodies.UserLogin;
import com.alntech.appointments.controller.RequestBodies.UserSignup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @PostMapping("/signup")
    public ResponseEntity<?> login(@RequestBody UserSignup userSignup) {
        return "Greetings from Spring Boot!";
    }

}