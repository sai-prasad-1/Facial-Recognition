package io.levantate.facialattendance.services;

import io.levantate.facialattendance.models.User;
import io.levantate.facialattendance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Basic login (no password security)
    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; 
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
