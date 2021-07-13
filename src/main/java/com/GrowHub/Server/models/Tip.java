package com.GrowHub.Server.models;


import com.GrowHub.Server.models.enums.Month;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="tips")
public class Tip extends TextContent{

    @Column
    @Enumerated(value= EnumType.STRING)
    private Month month;

    @JsonIgnoreProperties({"tips", "plots"})
//    @JsonBackReference(value="tips")
    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private User author;

    //CONSTRUCTOR
    public Tip(String date, User author, String title, String body, Month month) {
        super(date, title, body);
        this.month = month;
        this.author = author;
    }

    public Tip(){}

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
