package com.alntech.appointments.services;

import com.alntech.appointments.commonrequestbodies.UserSignup;
import com.alntech.appointments.data.entities.User;
import com.alntech.appointments.data.repositories.UserRepository;
import com.alntech.appointments.services.exceptions.UserWithEmailAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserSignup userSignup) throws UserWithEmailAlreadyExists {
        // check if user with email exists
//        List<User> usersWithEmail = userRepository.findAllByEmail(userSignup.getEmail());
//        if (!usersWithEmail.isEmpty()) {
//            throw new UserWithEmailAlreadyExists("attempting to create duplicate user");
//        } else {
//            User newUser = User.builder()
//                    .name(userSignup.getName())
//                    .email(userSignup.getEmail())
//                    .password(userSignup.getPassword())
//                    .build();
//            userRepository.save(newUser);
//        }
    }
}
