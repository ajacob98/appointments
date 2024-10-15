package com.alntech.appointments.data.repositories;

import com.alntech.appointments.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAllByEmail(String email);
}
