package com.alex.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRespository personRespository;

    @GetMapping("/persons")
    public List<Person> index(){
        return personRespository.findAll();
    }


    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        personRespository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
