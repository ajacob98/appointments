package com.alntech.appointments.controller.UserController.RequestBodies;

import lombok.Data;

@Data
public class UserSignup {
    private String name;
    private String password;
    private String email;
}
