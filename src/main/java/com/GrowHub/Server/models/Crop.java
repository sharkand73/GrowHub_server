package com.GrowHub.Server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="crops")
public class Crop {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @JsonIgnoreProperties({"crops", "email", "password", "yearJoined", "yearLeft", "plots"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {
                    @JoinColumn(name = "crop_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false )
            }
    )
    private List<User> users;

    //CONSTRUCTOR
    public Crop(String name) {
        this.id = id;
        this.name = name;
        this.users = new ArrayList<>();
    }

    public Crop() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
