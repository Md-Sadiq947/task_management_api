package com.sadique.task_api.controller;

import com.sadique.task_api.entity.User;
import com.sadique.task_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers(){
        ResponseEntity<?> all = userService.getAll();
        return all;
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createAdmin(@RequestBody User user){
        return userService.saveAdmin(user);
    }
}
