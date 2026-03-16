package com.sadique.task_api.controller;

import com.sadique.task_api.entity.Person;
import com.sadique.task_api.repository.PersonRepository;
import com.sadique.task_api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping("/fetch")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @PostMapping("/insert")
    public boolean createPerson(@RequestBody Person person){
        return personService.insert(person);
    }

    @GetMapping("/fetchId/{myid}")
    public Optional<Person>getbyId(@PathVariable Long myid){
        return personService.getbyId(myid);
    }

    @DeleteMapping("/delete/{myID}")
    public boolean deletebyID(@PathVariable long myID){
        return personService.deletebyID(myID);
    }

    @PutMapping("/update/{id}")
    public Person updatebyId(@PathVariable long id, @RequestBody Person person){
        return personService.updatebyID(id,person);
    }
}
