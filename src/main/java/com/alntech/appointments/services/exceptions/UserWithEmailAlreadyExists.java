package com.alntech.appointments.services.exceptions;

public class UserWithEmailAlreadyExists extends Exception {
    public UserWithEmailAlreadyExists(String message) {
        super(message);
    }
}
