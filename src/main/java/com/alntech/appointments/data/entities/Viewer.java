package com.alntech.appointments.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@Entity
public class Viewer extends User{
    @OneToMany(mappedBy = "viewer")
    private List<Appointment> appointments;
}
