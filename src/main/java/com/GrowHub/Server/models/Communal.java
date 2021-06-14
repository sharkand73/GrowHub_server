package com.GrowHub.Server.models;

import com.GrowHub.Server.models.enums.AreaType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="communal_areas")
public class Communal extends Area{

    @Column(name="area_type")
    @Enumerated(value= EnumType.STRING)
    private AreaType areaType;

    @Column(name="plot_numbers")
    private String plotNumbers;

    @Column(name="area_info")
    private String areaInfo;

    @JsonIgnoreProperties(value="communal_areas")
    @OneToMany(mappedBy = "communal", fetch=FetchType.LAZY)
    private List<Job> jobs;

    //CONSTRUCTOR
    public Communal(String areaName, AreaType areaType, String areaInfo) {
        super(areaName);
        this.areaType = areaType;
        this.plotNumbers = "";
        this.areaInfo = areaInfo;
        this.jobs = new ArrayList<>();
    }

    public Communal(){

    }

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }

    public String getPlotNumbers() {
        return plotNumbers;
    }

    public void setPlotNumbers(String plotNumbers) {
        this.plotNumbers = plotNumbers;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void addJob(Job job){
        this.jobs.add(job);
    }
}
