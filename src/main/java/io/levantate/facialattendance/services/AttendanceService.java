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

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private UserRepository userRepository;

    private static final ZoneId IST_ZONE = ZoneId.of("Asia/Kolkata"); // IST ZoneId

    // Get all attendance records for a user
    public List<Attendance> getAllAttendanceByUser(User user) {
        return attendanceRepository.findByUser(user);
    }

    // Record attendance (simplified)
    public Attendance recordAttendance(String name) {
        User user = userRepository.findByName(name);
        Attendance attendance = new Attendance();
        attendance.setUser(user);
        attendance.setTimestamp(LocalDateTime.now(IST_ZONE));
        return attendanceRepository.save(attendance);
    }   
}