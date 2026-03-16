package com.sadique.task_api.service;

import com.sadique.task_api.entity.Person;
import com.sadique.task_api.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public boolean insert(Person person){
        personRepository.save(person);
        return true;
    }

    public Optional<Person> getbyId(Long id){
        return personRepository.findById(id);
    }

    public boolean deletebyID(Long id){
        if(personRepository.existsById(id)){
            personRepository.deleteById(id);
        }
        else throw new RuntimeException(id + " is not found");
        return true;
    }
    @Transactional
    public Person updatebyID(Long id, Person person){
        Person old = personRepository.findById(id).orElse(null);
        if(old != null){
            old.setFirst_name(person.getFirst_name() != null ? person.getFirst_name() : old.getFirst_name());
            old.setLast_name(person.getLast_name() != null ? person.getLast_name() : old.getLast_name());
            old.setEmail(person.getEmail() != null ? person.getEmail() : old.getEmail());
            old.setGender(person.getGender()!=null ? person.getGender(): old.getGender());
            old.setDate_of_birth(person.getDate_of_birth() != null ? person.getDate_of_birth() : old.getDate_of_birth());
            old.setCountry_of_birth(person.getCountry_of_birth()!=null ? person.getCountry_of_birth() : old.getCountry_of_birth());
        }

        return (old);
    }

}
//Controller -> Service -> Repository