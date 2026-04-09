package com.sadique.task_api.controller;

import com.sadique.task_api.entity.User;
import com.sadique.task_api.repository.UserRepository;
import com.sadique.task_api.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @PostMapping
    public ResponseEntity<?> saveEntry(@RequestBody User user){
        return userService.insert(user);
    }

    @GetMapping("/fetchId/{myid}")
    public ResponseEntity<?> getbyId(@PathVariable Integer myid){
        return userService.getbyId(myid);
    }


    @PutMapping
    public ResponseEntity<?> updateRecord(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User old = userService.findByuserName(name);

        if(old != null){
            old.setUserName(user.getUserName());

            old.setPassword(user.getPassword());
            userService.insert(old);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @Transactional
    @DeleteMapping
    public ResponseEntity<?> deleteUser(){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String name = authentication.getName();
            userRepository.deleteByUserName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
