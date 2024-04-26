package io.levantate.facialattendance.repository;

import io.levantate.facialattendance.models.Attendance;
import io.levantate.facialattendance.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    public List<Attendance> findByUser(User user);
}
