package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.Plot;
import com.GrowHub.Server.repositories.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlotController {

    @Autowired
    PlotRepository plotRepository;

    @GetMapping(value = "/plots")
    public ResponseEntity getAllPlots(){
       return new ResponseEntity(plotRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/plots/{id}")
    public ResponseEntity<Plot> getPlot(@PathVariable Long id){
        return new ResponseEntity(plotRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/plots/{id}")
    public ResponseEntity<Plot> putPlot(@RequestBody Plot plot, @PathVariable Long id){
        Plot plotToUpdate = plotRepository.findById(id).get();
        plotToUpdate.setAreaName(plot.getAreaName());
        plotToUpdate.setPlotNumber(plot.getPlotNumber());
        plotToUpdate.setBreadth(plot.getBreadth());
        plotToUpdate.setLength(plot.getLength());
        plotToUpdate.setFlat(plot.isFlat());
        plotToUpdate.setUsers(plot.getUsers());
        plotToUpdate.setComments(plot.getComments());
        plotToUpdate.setJobs(plot.getJobs());
        return new ResponseEntity<>(plotToUpdate, HttpStatus.OK);
    }

    // decided to leave out delete and post mappings as its assumed the allotment
    // is static and plots won't be added or removed, same with communal


}
