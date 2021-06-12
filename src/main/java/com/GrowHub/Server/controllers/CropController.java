package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.Crop;
import com.GrowHub.Server.repositories.CommunalRepository;
import com.GrowHub.Server.repositories.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CropController {

    @Autowired
    CropRepository cropRepository;

    @GetMapping(value = "/crops")
    public ResponseEntity getAllCrops() {
        return new ResponseEntity(cropRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/crops/{id}")
    public ResponseEntity<Crop> getCrop(@PathVariable Long id){
        return new ResponseEntity(cropRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/crops")
    public ResponseEntity<Crop> postCrop(@RequestBody Crop crop){
        cropRepository.save(crop);
        return new ResponseEntity<>(crop, HttpStatus.CREATED);
    }

    @PutMapping(value = "/crops/{id}")
    public ResponseEntity<Crop> putCrop(@RequestBody Crop crop, @PathVariable Long id){
        Crop cropToUpdate = cropRepository.findById(id).get();
        cropToUpdate.setUsers(crop.getUsers());
        cropToUpdate.setName(crop.getName());
        cropRepository.save(cropToUpdate);
        return new ResponseEntity<>(cropToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value = "/crops/{id}")
    public ResponseEntity<Long> deleteCrop(@PathVariable Long id){
        cropRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}


