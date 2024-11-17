package com.alntech.appointments.controllers.ExpertController.RequestBodies;

import lombok.Data;

@Data
public class Interval{
    private String startTime;
    private int durationMins;
}