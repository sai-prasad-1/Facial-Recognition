package io.levantate.facialattendance.services;

import io.levantate.facialattendance.models.Attendance;
import io.levantate.facialattendance.models.User;
import io.levantate.facialattendance.repository.AttendanceRepository;
import io.levantate.facialattendance.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;


    private static final ZoneId IST_ZONE = ZoneId.of("Asia/Kolkata"); // IST ZoneId

    // Get all attendance records for a user
    public List<Attendance> getAllAttendanceByUser(Long id) 
    {
        List<Attendance> attendanceList = attendanceRepository.findByUserId(id);
        return attendanceList;
        
    }

    public Attendance recordAttendance(Long id) {
        Attendance attendance = new Attendance();
        attendance.setUserId(id);;
        attendance.setTimestamp(LocalDateTime.now(IST_ZONE));
        return attendanceRepository.save(attendance);

    }

}