package com.alntech.appointments.data.entities;


import com.alntech.appointments.data.entities.enums.Day;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DaySchedule {
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private Day day;

    private LocalDateTime startTime;

    private int durationMinutes;

    @ManyToOne
    private Expert expert;

}
