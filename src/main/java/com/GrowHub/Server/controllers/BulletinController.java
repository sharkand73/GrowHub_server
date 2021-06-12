package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.BulletinItem;
import com.GrowHub.Server.repositories.BulletinItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BulletinController {

    @Autowired
    BulletinItemRepository bulletinItemRepository;

    @GetMapping(value = "/bulletins")
    public ResponseEntity getAllBulletins() {
        return new ResponseEntity(bulletinItemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bulletins/{id}")
    public ResponseEntity<BulletinItem> getBulletin(@PathVariable Long id){
        return new ResponseEntity(bulletinItemRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/bulletins/{id}")
    public ResponseEntity<BulletinItem> putBulletin(@RequestBody BulletinItem bulletin, @PathVariable Long id){
        BulletinItem bulletinToUpdate = bulletinItemRepository.findById(id).get();
        bulletinToUpdate.setAuthor(bulletin.getAuthor());
        bulletinToUpdate.setBody(bulletin.getBody());
        bulletinToUpdate.setDate(bulletin.getDate());
        bulletinToUpdate.setTitle(bulletin.getTitle());
        return new ResponseEntity<>(bulletinToUpdate, HttpStatus.OK);
    }

    @PostMapping("/bulletins")
    public ResponseEntity<BulletinItem> postBulletin(@RequestBody BulletinItem bulletin){
        bulletinItemRepository.save(bulletin);
        return new ResponseEntity<>(bulletin, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/bulletins/{id}")
    public ResponseEntity<Long> deleteBulletin(@PathVariable Long id){
        bulletinItemRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
