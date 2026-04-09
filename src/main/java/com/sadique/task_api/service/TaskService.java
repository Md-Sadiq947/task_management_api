package com.sadique.task_api.service;

import com.sadique.task_api.entity.Task;
import com.sadique.task_api.entity.User;
import com.sadique.task_api.repository.TaskRepository;
import com.sadique.task_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<?> getAllTaskByUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userRepository.findByuserName(name);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<Task> list = user.getTasks();
        if(list !=null && !list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> createEntry(Task task){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String name = authentication.getName();
            User user = userRepository.findByuserName(name);
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userRepository.findByuserName(name);
        List<Task> tasks = user.getTasks().stream().filter(task -> task.getId()==(id)).collect(Collectors.toUnmodifiableList());

        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?>deletebyId(Integer id,String name){
        try {
            User user = userRepository.findByuserName(name);
            boolean remove = user.getTasks().removeIf(x -> x.getId() == id);

            if(remove){
                userRepository.save(user);
                taskRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }

    }
    @Transactional
    public ResponseEntity<?>updateTaskbyID(Integer id, Task task,String name){
        User user = userRepository.findByuserName(name);
        List<Task> task1 = user.getTasks().stream().filter(x -> x.getId()==(id)).collect(Collectors.toUnmodifiableList());

        if(!task1.isEmpty()){
            Task task2 = taskRepository.findById(id).orElse(null);
            if(task2 != null){
                task2.setTitle(task.getTitle()!=null?task.getTitle(): task2.getTitle());
                task2.setDescription(task.getDescription()!=null?task.getDescription():task2.getDescription());
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
