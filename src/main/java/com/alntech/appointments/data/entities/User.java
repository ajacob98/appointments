package com.alntech.appointments.data.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "all_users")
public class User {

    @Id
    private long id;
    
    private String name;
    private String email;
    private String password;

    @OneToOne(mappedBy = "user")
    private Balance balance;

}
