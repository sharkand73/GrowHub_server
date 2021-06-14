package com.GrowHub.Server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "areas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Area {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String areaName;

    @JsonIgnoreProperties(value="areas")
    @OneToMany(mappedBy = "area", fetch=FetchType.LAZY)
    private List<Job> jobs;


    //CONSTRUCTOR
    public Area(String areaName) {
        this.areaName = areaName;
        this.jobs = new ArrayList<>();
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

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }


}
