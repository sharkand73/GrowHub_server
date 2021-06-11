package com.GrowHub.Server.models;

import com.GrowHub.Server.models.enums.PositionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String shortName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private PositionType position;

    @Column
    private boolean onCommittee;

    @Column
    private int yearJoined;

    @Column
    private int yearLeft;

    @JsonIgnoreProperties(value = "users")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "plot_id", nullable = false, updatable = false )
            }
    )
    private List<Plot> plots;

    @JsonIgnoreProperties(value = "users")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "job_id", nullable = false, updatable = false)
            }
    )
    private List<Job> jobs;

    @JsonIgnoreProperties(value = "users")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "crop_id", nullable = false, updatable = false)
            }
    )
    private List<Crop> crops;

    //CONSTRUCTOR

    public User(String shortName, String email, String password, PositionType position, int yearJoined) {
        this.shortName = shortName;
        this.email = email;
        this.password = password;
        this.position = position;
        this.onCommittee = isOnCommittee();
        this.yearJoined = yearJoined;
        this.yearLeft = 0;
        this.crops = new ArrayList<>();
        this.plots = new ArrayList<>();
        this.jobs = new ArrayList<>();
        this.id = id;

    }

    public User() {
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PositionType getPosition() {
        return position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    public boolean getOnCommittee() {
        return onCommittee;
    }

    public void setOnCommittee(boolean onCommittee) {
        this.onCommittee = onCommittee;
    }

    public int getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }

    public int getYearLeft() {
        return yearLeft;
    }

    public void setYearLeft(int yearLeft) {
        this.yearLeft = yearLeft;
    }

    public List<Crop> getCrops() {
        return crops;
    }

    public void setCrops(List<Crop> crops) {
        this.crops = crops;
    }

    public List<Plot> getPlots() {
        return plots;
    }

    public void setPlots(List<Plot> plots) {
        this.plots = plots;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    // add/remove job functions?

    public boolean isOnCommittee() {
        return !(position == PositionType.NONE || position == PositionType.INACTIVE);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
