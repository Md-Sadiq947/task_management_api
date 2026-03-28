package com.sadique.task_api.service;

import com.sadique.task_api.entity.User;
import com.sadique.task_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<?> getAll(){
        List<User> list = userRepository.findAll();
        if(list!=null)return new ResponseEntity<>(userRepository.findAll(), HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?>insert(User user){
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    public ResponseEntity<? extends Object> getbyId(Integer id){
        Optional<User> p = userRepository.findById(id);
        if(p != null  &&  !p.isEmpty()){
            return new ResponseEntity<>(p, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> deletebyID(Integer id){
        User old = userRepository.findById(id).orElse(null);
        if(old!=null){
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public void updateRecord(User user){
        User old = userRepository.findByuserName(user.getUserName());
        if(old != null){
            old.setUserName(user.getUserName());
            old.setPassword(user.getPassword());
            userRepository.save(old);
        }

    }
    public User findByuserName(String userName){
        return userRepository.findByuserName(userName);
    }

}
