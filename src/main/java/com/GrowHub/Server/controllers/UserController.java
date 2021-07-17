package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.Plot;
import com.GrowHub.Server.models.User;
import com.GrowHub.Server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity getAllUsers(){
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> postUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> putUser(@RequestBody User user, @PathVariable Long id){
        User foundUser = userRepository.findById(id).get();
//        foundUser.setJobs(user.getJobs());
        foundUser.setCrops(user.getCrops());
        foundUser.setPosition(user.getPosition());
        foundUser.setPlots(user.getPlots());
//        foundUser.setOnCommittee(user.getOnCommittee());
        foundUser.setShortName(user.getShortName());
        foundUser.setYearJoined(user.getYearJoined());
        foundUser.setYearLeft(user.getYearLeft());
        foundUser.setReplies(user.getReplies());
        userRepository.save(foundUser);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/users/plots/{plotNumber}")
    public ResponseEntity<User> findByPlotsPlotNumber(@PathVariable int plotNumber){
        List<User> foundUsers = userRepository.findByPlotsPlotNumber(plotNumber);
        return new ResponseEntity(foundUsers, HttpStatus.OK);
    }
}
