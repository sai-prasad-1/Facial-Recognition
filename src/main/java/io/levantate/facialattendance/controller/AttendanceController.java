package io.levantate.facialattendance.controller;

import io.levantate.facialattendance.models.Attendance;
import io.levantate.facialattendance.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public ResponseEntity<Attendance> recordAttendance(@RequestBody String name) {
        try {
            Attendance recordedAttendance = attendanceService.recordAttendance(name);
            return ResponseEntity.ok(recordedAttendance); // Return the recorded attendance on success
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Return a 404 if the user is not found
        } 
    }
}
