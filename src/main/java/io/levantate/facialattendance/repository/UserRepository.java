package io.levantate.facialattendance.repository;

import io.levantate.facialattendance.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email); 
    User findByName(String name);
}
