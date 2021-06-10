package com.GrowHub.Server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String areaName;

    @JsonIgnoreProperties(value="area")
    @OneToMany(mappedBy = "area", fetch=FetchType.LAZY)
    private ArrayList<Job> jobs;


    public Area(String areaName) {
        this.areaName = areaName;
        this.id = id;
    }

    public Area() {
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }
}
