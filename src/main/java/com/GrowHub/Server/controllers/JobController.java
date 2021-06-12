package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.Job;
import com.GrowHub.Server.repositories.CommunalRepository;
import com.GrowHub.Server.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @GetMapping(value = "/jobs")
    public ResponseEntity getAllJobs() {
        return new ResponseEntity(jobRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/jobs/{id}")
    public ResponseEntity getJob(@PathVariable Long id){
        return new ResponseEntity(jobRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/jobs")
    public ResponseEntity postJob(@RequestBody Job job){
        jobRepository.save(job);
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }

    @PutMapping(value = "/jobs/{id}")
    public ResponseEntity putJob(@RequestBody Job job, @PathVariable Long id){
        Job jobToUpdate = jobRepository.findById(id).get();
        jobToUpdate.setUsers(job.getUsers());
        jobToUpdate.setArea(job.getArea());
        jobToUpdate.setDeadline(job.getDeadline());
        jobToUpdate.setDifficulty(job.getDifficulty());
        jobToUpdate.setAuthor(job.getAuthor());
        jobToUpdate.setBody(job.getBody());
        jobToUpdate.setDate(job.getDate());
        jobToUpdate.setTitle(job.getTitle());
        jobRepository.save(jobToUpdate);
        return new ResponseEntity(jobToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/jobs/{id}")
    public ResponseEntity<Long> deleteJob(@PathVariable Long id){
        jobRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}

