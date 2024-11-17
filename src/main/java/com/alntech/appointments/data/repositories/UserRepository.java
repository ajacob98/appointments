package com.alntech.appointments.data.repositories;
import com.alntech.appointments.data.entities.User;
import com.alntech.appointments.data.entities.projections.IdOnly;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<IdOnly> findAllByEmail(String email);
}