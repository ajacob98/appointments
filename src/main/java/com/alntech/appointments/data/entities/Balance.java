package com.alntech.appointments.data.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "balance")
public class Balance {

    @Id
    private long balanceId;

    private long balance;
    private boolean blocked;

    @OneToOne
    @MapsId
    private User user;

}