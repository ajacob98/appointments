package com.alntech.appointments.data.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Topic {
    @Id
    private String topicId;

    private String topicName;

    @ManyToMany(mappedBy = "topics")
    private List<Expert> experts;
}
