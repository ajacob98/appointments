package com.alntech.appointments.data.repositories;

import com.alntech.appointments.data.entities.Expert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExpertRepository extends CrudRepository<Expert, Long> {
}