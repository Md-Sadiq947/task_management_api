package com.sadique.task_api.service;

import com.sadique.task_api.entity.Task;
import com.sadique.task_api.entity.User;
import com.sadique.task_api.repository.TaskRepository;
import com.sadique.task_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> getAllTaskByUser(String userName){
        User user = userRepository.findByuserName(userName);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<Task> list = user.getTasks();
        if(list !=null){
            return new ResponseEntity<>(list, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> createEntry(Task task, String userName){
        try {
            User user = userRepository.findByuserName(userName);
            if(user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            task.setCreatedAt(LocalDate.now());
            task.setUser(user);
            user.getTasks().add(task);

            taskRepository.save(task);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?>getbyId(Integer id){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?>deletebyId(Integer id){
        Task task = taskRepository.findById(id).orElse(null);
        if(task!= null){
            taskRepository.delete(task);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Transactional
    public ResponseEntity<?>updateTaskbyID(Integer id, Task task){
        Task task1 = taskRepository.findById(id).orElse(null);
        if(task1 != null){
            task1.setTitle(task.getTitle()!=null ? task.getTitle() : task1.getTitle());
            task1.setDescription(task.getDescription() != null ? task.getDescription() : task1.getDescription());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
