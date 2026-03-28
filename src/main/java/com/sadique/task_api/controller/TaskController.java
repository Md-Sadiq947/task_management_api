package com.sadique.task_api.controller;

import com.sadique.task_api.entity.Task;
import com.sadique.task_api.service.TaskService;
import com.sadique.task_api.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;


    @GetMapping("{userName}")
    public ResponseEntity<?> getAllTaskByUser(@PathVariable String userName){
        return taskService.getAllTaskByUser(userName);
    }
    @PostMapping("{userName}")
    public ResponseEntity<?> createEntry(@PathVariable String userName, @RequestBody Task task){
        return taskService.createEntry(task, userName);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getbyId(@PathVariable Integer id){
        return taskService.getbyId(id);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deletebyId(@PathVariable Integer id){
        return taskService.deletebyId(id);
    }

    @Transactional
    @PutMapping("/id/{id}")
    public ResponseEntity<?>updateTaskbyId(@PathVariable int id, @RequestBody Task task){
        return taskService.updateTaskbyID(id,task);
    }

}
