package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.Reply;
import com.GrowHub.Server.repositories.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReplyController {

    @Autowired
    ReplyRepository replyRepository;

    @GetMapping(value = "/replies")
    public ResponseEntity getAllReplies(){
        return new ResponseEntity(replyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/replies/{id}")
    public ResponseEntity getReply(@PathVariable Long id){
        return new ResponseEntity(replyRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/replies")
    public ResponseEntity<Reply> postReply(@RequestBody Reply reply){
        replyRepository.save(reply);
        return new ResponseEntity(reply, HttpStatus.CREATED);
    }

    @PutMapping(value = "/replies/{id}")
    public ResponseEntity<Reply> putReply(@RequestBody Reply reply, @PathVariable Long id){
        Reply replyToUpdate = replyRepository.findById(id).get();
        replyToUpdate.setBody(reply.getBody());
        replyToUpdate.setAuthor(reply.getAuthor());
        reply.setDate(reply.getDate());
        replyRepository.save(replyToUpdate);
        return new ResponseEntity(replyToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/replies/{id}")
    public ResponseEntity<Long> deleteReply(@PathVariable Long id){
        replyRepository.deleteById(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

}
