package com.alntech.appointments.data.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="day_schedules")
public class DaySchedule {
    @Id
    private long id;

    private String day;

    private LocalTime startTime;

    private int durationMinutes;

    private long expertId;

}
