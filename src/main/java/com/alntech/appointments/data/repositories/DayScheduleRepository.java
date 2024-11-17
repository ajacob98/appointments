package com.alntech.appointments.data.repositories;


import com.alntech.appointments.data.entities.DaySchedule;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DayScheduleRepository extends CrudRepository<DaySchedule, Long> {
    @Modifying
    @Query("DELETE FROM day_schedules WHERE expert_id = :expertId")
    void deleteByExpertId(long expertId);
}
