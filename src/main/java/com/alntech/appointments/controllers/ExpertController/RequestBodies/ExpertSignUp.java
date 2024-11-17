package com.alntech.appointments.controllers.ExpertController.RequestBodies;

import com.alntech.appointments.commonrequestbodies.UserSignup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExpertSignUp extends UserSignup {
    private String qualification;
    private String timezone;
}
