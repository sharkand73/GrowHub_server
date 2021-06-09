package com.GrowHub.Server.models;

import com.GrowHub.Server.models.enums.PositionType;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String shortName;
    private String email;
    private String password;
    private PositionType position;
    private int yearJoined;
    private int yearLeft;
    private List<String> growing;
    private List<Plot> plots;
    private List<Job> jobs;

    public User(String shortName, String email, String password, PositionType position, int yearJoined) {
        this.shortName = shortName;
        this.email = email;
        this.password = password;
        this.position = position;
        this.yearJoined = yearJoined;
        this.yearLeft = 0;
        this.growing = new ArrayList<>();
        this.plots = new ArrayList<Plot>();
        this.jobs = new ArrayList<Job>();
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

    public List<String> getGrowing() {
        return growing;
    }

    public void setGrowing(List<String> growing) {
        this.growing = growing;
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
}
