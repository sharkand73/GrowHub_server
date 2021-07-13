package com.GrowHub.Server.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="jobs")
public class Job extends TextContent{

//    @JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//    @JsonSubTypes({
//            @JsonSubTypes.Type(value = Plot.class, name = "plot"),
//            @JsonSubTypes.Type(value = Communal.class, name = "communal")
//    })

    @JsonIgnoreProperties({"jobs"})
    @ManyToOne
    @JoinColumn(name="communal_id", nullable = false)
    private Communal communal;

    @Column
    private String deadline;

    @Column
    private int difficulty;

//    @JsonIgnoreProperties(value="jobs")
//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            joinColumns = {
//                    @JoinColumn(name = "job_id", nullable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "user_id", nullable = false, updatable = false)
//            }
//    )
//    private List<User> jobUsers;

    @JsonIgnoreProperties({"jobs", "email", "password", "yearJoined", "yearLeft", "plots", "crops"})
    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private User author;

    //CONSTRUCTOR
    public Job(String date, User author, String title, String body, Communal communal, String deadline, int difficulty) {
        super(date, title, body);
        this.communal = communal;
        this.deadline = deadline;
        this.difficulty = difficulty;
        this.author = author;
//        this.users = new ArrayList<>();
    }

    public Job() {

    }

    public Communal getCommunal() {
        return communal;
    }

    public void setCommunal(Communal communal) {
        this.communal = communal;
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

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }


    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
