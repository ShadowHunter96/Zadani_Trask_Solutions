package com.shadowhunter.jpa.controller;

import com.shadowhunter.jpa.dto.TechnologyRequest;
import com.shadowhunter.jpa.dto.UserRequest;
import com.shadowhunter.jpa.entity.Technology;
import com.shadowhunter.jpa.entity.User;
import com.shadowhunter.jpa.exception.ResourceNotFoundException;
import com.shadowhunter.jpa.repository.TechnologyRepository;
import com.shadowhunter.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TechnologyRepository technologyRepository;


    @PostMapping("/saveUser")
    public User saveUser(@RequestBody UserRequest user){
        return userRepository.save(user.getUser());
    }

    @GetMapping("/findAllUsers")
    public List<User> findAllUsers(){

        return userRepository.findAll();
    }

    @PostMapping("/saveTechnology")
    public Technology saveTechnology(@RequestBody TechnologyRequest technology) {
        return technologyRepository.save(technology.getTechnology());}

    @GetMapping("/findAllTechnologies")
    public List<Technology>findALllTechnologies(){
        return technologyRepository.findAll();
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id")int id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/findTechnology/{id}")
    public ResponseEntity<Technology>getTechnologyByID(@PathVariable("id")int id){
        Technology technology = technologyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        return new ResponseEntity<>(technology,HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id")int id,@RequestBody User user  ){
        User updateUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

        updateUser.setName(user.getName());
        updateUser.setTechnology(user.getTechnology());
        updateUser.setTechnologyinfo(user.getTechnologyinfo());
        updateUser.setTechnologylevel(user.getTechnologylevel());

        userRepository.save(updateUser);
        return ResponseEntity.ok(updateUser);
    }

    @PutMapping("/updateTechnology/{id}")
    public ResponseEntity<Technology> updateTechnology(@PathVariable("id")int id, @RequestBody Technology technology){
        Technology updateTechnology = technologyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

        updateTechnology.setTname(updateTechnology.getTname());
        updateTechnology.setTuser(updateTechnology.getTuser());
        updateTechnology.setTechnologyInfo(updateTechnology.getTechnologyInfo());
        updateTechnology.setTechnologyLevel(updateTechnology.getTechnologyLevel());
        technologyRepository.save(updateTechnology);
        return ResponseEntity.ok(updateTechnology);
    }


    @DeleteMapping("/deleteTechnology/{id}")
    public ResponseEntity<HttpStatus> deleteTechnology(@PathVariable("id")int id){
        technologyRepository.deleteById(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id")int id ){
        userRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
