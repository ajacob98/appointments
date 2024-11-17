package com.alntech.appointments.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "all_users")
public class User {
    @Id
    private Long id;
    
    private String name;
    private String email;
    private String password;
}
