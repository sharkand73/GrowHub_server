package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.Knowhow;
import com.GrowHub.Server.repositories.BulletinItemRepository;
import com.GrowHub.Server.repositories.KnowhowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KnowhowController {

    @Autowired
    KnowhowRepository knowhowRepository;

    @GetMapping(value = "/knowhows")
    public ResponseEntity getAllKnowhows() {
        return new ResponseEntity(knowhowRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/knowhows/{id}")
    public ResponseEntity getKnowhow(@PathVariable Long id){
        return new ResponseEntity(knowhowRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/knowhows")
    public ResponseEntity<Knowhow> postKnowhow(@RequestBody Knowhow knowhow){
        knowhowRepository.save(knowhow);
        return new ResponseEntity<>(knowhow, HttpStatus.CREATED);
    }

    @PutMapping(value = "/knowhows/{id}")
    public ResponseEntity<Knowhow> putKnowhow(@RequestBody Knowhow knowhow, @PathVariable Long id){
        Knowhow knowhowToUpdate = knowhowRepository.findById(id).get();
        knowhowToUpdate.setAuthor(knowhow.getAuthor());
        knowhowToUpdate.setBody(knowhow.getBody());
        knowhowToUpdate.setDate(knowhow.getDate());
        knowhowToUpdate.setTitle(knowhow.getTitle());
        knowhowToUpdate.setMonth(knowhow.getMonth());
        return new ResponseEntity<>(knowhowToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/knowhows/{id}")
    public ResponseEntity<Long> deleteKnowhow(@PathVariable Long id){
        knowhowRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
