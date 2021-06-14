package com.GrowHub.Server.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bulletins")
public class BulletinItem extends TextContent{

    @JsonIgnoreProperties(value = "bulletins")
    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private User author;

    //CONSTRUCTOR
    public BulletinItem(String date, User author, String title, String body) {
        super(date, title, body);
        this.author = author;
    }

    public BulletinItem() {
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public boolean isFromCommittee(){
            return author.isOnCommittee();
        }


}
