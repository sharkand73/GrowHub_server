package com.GrowHub.Server.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment extends TextContent{


    @JsonIgnoreProperties({"comments", "plots", "length", "breadth", "flat", "users"})
//    @JsonBackReference(value="comments_plot")
    @ManyToOne
    @JoinColumn(name="plot_id", nullable = false)
    private Plot plot;

    @JsonIgnoreProperties({"comments", "plots", "length", "breadth", "flat", "email", "password", "yearJoined", "yearLeft", "crops"})
//    @JsonBackReference(value="comments_author")
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JoinColumn(name="author_id", nullable = false)
    private User author;

    //CONSTRUCTOR
    public Comment(String date, User author, String title, String body, Plot plot) {
        super(date, title, body);
        this.plot = plot;
        this.author = author;
    }

    public Comment() {
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
