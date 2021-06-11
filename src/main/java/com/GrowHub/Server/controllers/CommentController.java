package com.GrowHub.Server.controllers;

import com.GrowHub.Server.repositories.BulletinItemRepository;
import com.GrowHub.Server.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping(value = "/comments")
    public ResponseEntity getAllComments() {
        return new ResponseEntity(commentRepository.findAll(), HttpStatus.OK);
    }


}
