package com.GrowHub.Server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Job extends TextContent{

    @JsonIgnoreProperties(value="jobs")
    @ManyToOne
    @JoinColumn(name="area_id", nullable = false)
    private Area area;

    @Column
    private String deadline;

    @Column
    private int difficulty;

    @JsonIgnoreProperties(value="jobs")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "job_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false)
            }
    )
    private List<User> users;


    public Job(String date, User author, String title, String body, Area area, String deadline, int difficulty) {
        super(date, author, title, body);
        this.area = area;
        this.deadline = deadline;
        this.difficulty = difficulty;
        this.users = new ArrayList<>();
    }

    public Job() {
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
