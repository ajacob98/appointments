package com.alntech.appointments.controllers.ExpertController.ResponseBodies;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExpertCreatedResponse {
    private long userId;
}
