package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.Comment;
import com.GrowHub.Server.repositories.BulletinItemRepository;
import com.GrowHub.Server.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping(value = "/comments")
    public ResponseEntity getAllComments() {
        return new ResponseEntity(commentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/comments/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id){
        return new ResponseEntity(commentRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/comments")
    public ResponseEntity<Comment> postComment(@RequestBody Comment comment){
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @PutMapping(value = "/comments/{id}")
    public ResponseEntity<Comment> putComment(@RequestBody Comment comment, @PathVariable Long id){
        Comment commentToUpdate = commentRepository.findById(id).get();
        commentToUpdate.setPlot(comment.getPlot());
        commentToUpdate.setAuthor(comment.getAuthor());
        commentToUpdate.setBody(comment.getBody());
        commentToUpdate.setDate(comment.getDate());
        commentToUpdate.setTitle(comment.getTitle());
        commentRepository.save(commentToUpdate);
        return new ResponseEntity<>(commentToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/comments/{id}")
    public ResponseEntity<Long> deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
