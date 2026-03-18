package com.sadique.task_api.service;

import com.sadique.task_api.entity.Person;
import com.sadique.task_api.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<?> getAll(){
        List<Person> list = personRepository.findAll();
        if(list!=null)return new ResponseEntity<>(personRepository.findAll(), HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> insert(Person person){
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    public ResponseEntity<? extends Object> getbyId(Long id){
        Optional<Person> p = personRepository.findById(id);
        if(p != null  &&  !p.isEmpty()){
            return new ResponseEntity<>(p, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> deletebyID(Long id){
        Person old = personRepository.findById(id).orElse(null);
        if(old!=null){
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Transactional
    public ResponseEntity<?> updatebyID(Long id, Person person){
        Person old = personRepository.findById(id).orElse(null);
        if(old != null){
            old.setFirst_name(person.getFirst_name() != null ? person.getFirst_name() : old.getFirst_name());
            old.setLast_name(person.getLast_name() != null ? person.getLast_name() : old.getLast_name());
            old.setEmail(person.getEmail() != null ? person.getEmail() : old.getEmail());
            old.setGender(person.getGender()!=null ? person.getGender(): old.getGender());
            old.setDate_of_birth(person.getDate_of_birth() != null ? person.getDate_of_birth() : old.getDate_of_birth());
            old.setCountry_of_birth(person.getCountry_of_birth()!=null ? person.getCountry_of_birth() : old.getCountry_of_birth());
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
//Controller -> Service -> Repository