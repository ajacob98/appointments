package com.alntech.appointments.controller.UserController;


import com.alntech.appointments.controller.UserController.RequestBodies.UserSignup;
import com.alntech.appointments.service.UserService;
import com.alntech.appointments.service.exceptions.UserAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    UserService userService;

    @Autowired
    Controller(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserSignup userSignup) throws UserAlreadyExists {
        try{
            userService.createUser(userSignup);
        } catch (UserAlreadyExists e) {
            throw e;
        }

        return new ResponseEntity<>("registered user", HttpStatus.OK);

    }

}