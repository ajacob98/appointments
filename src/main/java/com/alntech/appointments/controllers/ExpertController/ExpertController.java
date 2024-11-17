package com.alntech.appointments.controllers.ExpertController;

import com.alntech.appointments.controllers.ExpertController.RequestBodies.Interval;
import com.alntech.appointments.controllers.ExpertController.ResponseBodies.ExpertCreatedResponse;
import com.alntech.appointments.dto.DayDto;
import com.alntech.appointments.dto.ExpertDto;
import com.alntech.appointments.services.ExpertService;
import com.alntech.appointments.services.exceptions.UserWithEmailAlreadyExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController("expertController")
@RequestMapping("/expert")
public class ExpertController {

    private static final Logger logger = LoggerFactory.getLogger(ExpertController.class);

    ExpertService expertService;

    @Autowired
    ExpertController(ExpertService expertService){
        this.expertService=expertService;
    }

    @PostMapping("")
    public ResponseEntity<ExpertCreatedResponse> signUpExpert(@RequestBody ExpertDto expertDto) throws UserWithEmailAlreadyExists {
        try{
            long expertId=expertService.createExpert(expertDto);
            return new ResponseEntity<>(ExpertCreatedResponse.builder().userId(expertId).build(), HttpStatus.OK);
        } catch (UserWithEmailAlreadyExists e) {
            throw e;
        }
    }

    @PostMapping("/{expertId}/schedule")
    public ResponseEntity<?> updateSchedule(@PathVariable long expertId, @RequestBody Map<DayDto, List<Interval>> expertSchedules){
        logger.info(String.valueOf(expertSchedules));
        //check if expertSchedules is valid

        try{
            expertService.updateSchedule(expertId, expertSchedules);
        }
        catch (Exception e){
            throw e;
        }
        return new ResponseEntity<>("updated day schedule", HttpStatus.OK);
    }

}
