package com.alntech.appointments.dto;

import com.alntech.appointments.commonrequestbodies.UserSignup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExpertDto extends UserDto {
    private String qualification;
    private String timezone;
}
