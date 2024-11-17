package com.alntech.appointments.data.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "experts")
public class Expert{
    @Id
    private long userId;
    private String qualification;
    private String timeZone;
}
