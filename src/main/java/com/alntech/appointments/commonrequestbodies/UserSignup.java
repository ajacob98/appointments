package com.alntech.appointments.commonrequestbodies;

import lombok.Data;

@Data
public class UserSignup {
    private String name;
    private String password;
    private String email;
}
