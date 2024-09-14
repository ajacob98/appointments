package com.alntech.appointments.controller.RequestBodies;

import lombok.Data;

@Data
public class UserSignup {
    String userName;
    String password;
    String email;
}
