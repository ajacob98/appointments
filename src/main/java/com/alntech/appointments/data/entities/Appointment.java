package com.alntech.appointments.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Appointment {

    @Id
    private long id;

    private LocalDateTime startTime;

    private int durationMinutes;

    @ManyToOne
    private Expert expert;

    @ManyToOne
    private Viewer viewer;
}
