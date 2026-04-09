package com.sadique.task_api.controller;

import com.sadique.task_api.entity.Task;
import com.sadique.task_api.service.TaskService;
import com.sadique.task_api.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;


    @GetMapping()
    public ResponseEntity<?> getAllTaskByUser(){
        return taskService.getAllTaskByUser();
    }
    @PostMapping()
    public ResponseEntity<?> createEntry(@RequestBody Task task){
        return taskService.createEntry(task);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getbyId(@PathVariable Integer id){
        return taskService.getbyId(id);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deletebyId(@PathVariable Integer id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return taskService.deletebyId(id,name);
    }

    @Transactional
    @PutMapping("/id/{id}")
    public ResponseEntity<?>updateTaskbyId(@PathVariable int id, @RequestBody Task task){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return taskService.updateTaskbyID(id,task,name);
    }

}
