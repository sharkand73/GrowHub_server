package com.GrowHub.Server.models;

import com.GrowHub.Server.models.enums.AreaType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="plots")
public class Plot extends Area{


    @Column(name="plot_number")
    private int plotNumber;

    @Column
    private double length;

    @Column
    private double breadth;

    @Column
    private boolean isFlat;

//    @JsonBackReference(value="plot") //
    @JsonIgnoreProperties(value="plots")
    @OneToMany(mappedBy = "plot", fetch = FetchType.LAZY)
    private List<Comment> comments;

//    @JsonBackReference(value="plots") // this one works for knowhows, but not for jobs
    @JsonIgnoreProperties(value = "plots")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "users_plots",
            joinColumns = {
                    @JoinColumn(name = "plot_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false )
            }
    )
    private List<User> users;

    //CONSTRUCTOR
    public Plot(String areaName, int plotNumber, double length, double breadth, boolean isFlat) {
        super(areaName);
        this.plotNumber = plotNumber;
        this.length = length;
        this.breadth = breadth;
        this.isFlat = isFlat;
        this.users = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Plot() {
    }

    public int getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(int plotNumber) {
        this.plotNumber = plotNumber;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    public boolean isFlat() {
        return isFlat;
    }

    public void setFlat(boolean flat) {
        isFlat = flat;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        if (!this.users.contains(user)) {
            this.users.add(user);
            //user.addPlot(this);   // I was required to force this as Spring wasn't doing it.
        }
    }

    public void removeUser(User user) {
        if (this.users.contains(user)) {
            this.users.remove(user);
        }
    }

    public void addComment(Comment comment) {
            this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        if (this.comments.contains(comment)) {
            this.comments.remove(comment);
        }
    }






}
