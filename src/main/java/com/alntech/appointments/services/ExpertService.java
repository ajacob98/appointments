package com.alntech.appointments.services;

import com.alntech.appointments.controllers.ExpertController.RequestBodies.Interval;
import com.alntech.appointments.data.entities.DaySchedule;
import com.alntech.appointments.data.entities.Expert;
import com.alntech.appointments.data.entities.User;
import com.alntech.appointments.data.entities.projections.IdOnly;
import com.alntech.appointments.data.repositories.DayScheduleRepository;
import com.alntech.appointments.data.repositories.ExpertRepository;
import com.alntech.appointments.data.repositories.UserRepository;
import com.alntech.appointments.dto.DayDto;
import com.alntech.appointments.dto.ExpertDto;
import com.alntech.appointments.services.exceptions.UserDoesNotExist;
import com.alntech.appointments.services.exceptions.UserWithEmailAlreadyExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExpertService {

    private static final Logger logger = LoggerFactory.getLogger(ExpertService.class);


    ExpertRepository expertRepository;
    UserRepository userRepository;
    DayScheduleRepository dayScheduleRepository;
    JdbcAggregateTemplate jdbcAggregateTemplate;

    @Autowired
    ExpertService(ExpertRepository expertRepository, UserRepository userRepository, DayScheduleRepository dayScheduleRepository, JdbcAggregateTemplate jdbcAggregateTemplate) {
        this.expertRepository = expertRepository;
        this.userRepository=userRepository;
        this.jdbcAggregateTemplate=jdbcAggregateTemplate;
        this.dayScheduleRepository=dayScheduleRepository;
    }

    @Transactional
    public long createExpert(ExpertDto userSignup) throws UserWithEmailAlreadyExists {
        // check if user with email exists
        List<IdOnly> usersWithEmail = userRepository.findAllByEmail(userSignup.getEmail());
        if (!usersWithEmail.isEmpty()) {
            throw new UserWithEmailAlreadyExists("attempting to create duplicate user");
        }
        else {
            User newUser=User.builder().name(userSignup.getName()).email(userSignup.getEmail()).password(userSignup.getPassword()).build();
            var userId=userRepository.save(newUser).getId();
            Expert newExpert = Expert.builder()
                    .userId(userId)
                    .qualification(userSignup.getQualification())
                    .timeZone(userSignup.getTimezone())
                    .build();
            jdbcAggregateTemplate.insert(newExpert);
            return userId;
        }
    }

    @Transactional
    public void updateSchedule(long expertId, Map<DayDto, List<Interval>> expertSchedules){

        expertRepository.findById(expertId).orElseThrow(
                ()-> new UserDoesNotExist("the provided expert does not exist")
        );


        List<DaySchedule> daySchedules=new ArrayList<>();
        for(Map.Entry<DayDto, List<Interval>> entry: expertSchedules.entrySet()){
            String day= entry.getKey().name();
            for(Interval interval: entry.getValue()){
                int startTimeHour=Integer.valueOf(interval.getStartTime().substring(0,2));
                int startTimeMin=Integer.valueOf(interval.getStartTime().substring(3,5));
                DaySchedule daySchedule=DaySchedule.builder().expertId(expertId).day(day).startTime(LocalTime.of(startTimeHour, startTimeMin)).durationMinutes(interval.getDurationMins()).build();
                daySchedules.add(daySchedule);
            }
        }
        dayScheduleRepository.deleteByExpertId(expertId);
        dayScheduleRepository.saveAll(daySchedules);
    }
}