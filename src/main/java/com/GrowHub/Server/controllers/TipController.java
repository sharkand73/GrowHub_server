package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.Tip;
import com.GrowHub.Server.repositories.TipRepository;
import com.GrowHub.Server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TipController {

    @Autowired
    TipRepository tipRepository;

    @GetMapping(value = "/tips")
    public ResponseEntity getAllTips() {
        return new ResponseEntity(tipRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/tips/{id}")
    public ResponseEntity getTip(@PathVariable Long id){
        return new ResponseEntity(tipRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/tips")
    public ResponseEntity postTip(@RequestBody Tip tip){
        tipRepository.save(tip);
        return new ResponseEntity(tip, HttpStatus.CREATED);
    }

    @PutMapping(value = "/tips/{id}")
    public ResponseEntity putTip(@RequestBody Tip tip, @PathVariable Long id){
        Tip tipToUpdate = tipRepository.findById(id).get();
        tipToUpdate.setMonth(tip.getMonth());
        tipToUpdate.setAuthor(tip.getAuthor());
        tipToUpdate.setBody(tip.getBody());
        tipToUpdate.setTitle(tip.getTitle());
        tipToUpdate.setDate(tip.getDate());
        tipRepository.save(tipToUpdate);
        return new ResponseEntity(tipToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/tips/{id}")
    public ResponseEntity<Long> deleteTip(@PathVariable Long id){
        tipRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
