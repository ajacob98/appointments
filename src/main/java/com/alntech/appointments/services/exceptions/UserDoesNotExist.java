package com.alntech.appointments.services.exceptions;

public class UserDoesNotExist extends RuntimeException {
    public UserDoesNotExist(String message) {
        super(message);
    }
}
