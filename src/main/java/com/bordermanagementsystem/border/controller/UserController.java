package com.bordermanagementsystem.border.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bordermanagementsystem.border.model.User;
import com.bordermanagementsystem.border.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

      @Autowired
    private UserService userService;

    // Create User
    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Get User by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get User by Username
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.getUserByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
     // Update User
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User user = userService.updateUser(userId, updatedUser);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // Delete User
    @DeleteMapping("/userId")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    /**
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
        User user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (user != null) {
            return ResponseEntity.ok(user); // Return user data on success
        } 
        else {
            return ResponseEntity.badRequest().body("Invalid username or password");
}
}
}
