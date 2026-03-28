package com.sadique.task_api.controller;

import com.sadique.task_api.entity.User;
import com.sadique.task_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return userService.getAll();

    }

    @PostMapping
    public ResponseEntity<?> saveEntry(@RequestBody User user){
        return userService.insert(user);
    }

    @GetMapping("/fetchId/{myid}")
    public ResponseEntity<?> getbyId(@PathVariable Integer myid){
        return userService.getbyId(myid);
    }


    @PutMapping
    public void updateRecord(@RequestBody User user){
        userService.updateRecord(user);
    }

}
