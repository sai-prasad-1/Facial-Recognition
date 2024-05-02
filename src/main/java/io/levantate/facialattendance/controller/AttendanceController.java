package io.levantate.facialattendance.controller;

import io.levantate.facialattendance.models.Attendance;
import io.levantate.facialattendance.services.AttendanceService;
import io.levantate.facialattendance.utils.ErrorMessage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
public ResponseEntity<?> recordAttendance(@RequestBody Long id) { // Changed to ResponseEntity<?>
    try {
        Attendance recordedAttendance = attendanceService.recordAttendance(id);
        return ResponseEntity.ok(recordedAttendance);
    } catch (Exception e) {
        ErrorMessage error = new ErrorMessage("User not found", e.getMessage()); 
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    } 
}


    @GetMapping
    public List<Attendance> getMethodName(@RequestBody Long id) {
        return attendanceService.getAllAttendanceByUser(id);
    }
    


}


