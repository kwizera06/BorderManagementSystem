package com.bordermanagementsystem.border.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bordermanagementsystem.border.model.User;
import com.bordermanagementsystem.border.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository; 

    //create
    public User createUser(User user){
        return userRepository.save(user);
    }

    //read
    public Optional<User> getUserById(Long userId){
         return userRepository.findById(userId);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update
    public User updateUser(Long userId, User updatedUser) {
        if (userRepository.existsById(userId)) {
            updatedUser.setUserId(userId);
            return userRepository.save(updatedUser);
        }
        return null;
    }

    // Delete
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User loginUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (user.getPassword().equals(password)) { // Compare plain text (Not secure)
                return user; // Return user details if login is successful
            }
        }
        return null; // Return null if credentials are incorrect
}
}
