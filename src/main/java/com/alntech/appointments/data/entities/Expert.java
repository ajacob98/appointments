package com.alntech.appointments.data.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Expert extends User{
    private String qualification;
    private String timeZone;

    @ManyToMany
    @JoinTable(
            name="experts_topics"
    )
    private List<Topic> topics;

    @OneToMany(mappedBy = "expert")
    private List<DaySchedule> daySchedules;

    @OneToMany(mappedBy = "expert")
    private List<Appointment> appointments;
}
