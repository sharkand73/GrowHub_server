package com.GrowHub.Server.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bulletins")
public class BulletinItem extends TextContent{

    @JsonIgnoreProperties(value = "bulletins")
//    @JsonBackReference(value="bulletins")
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
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

//    public boolean isFromCommittee(){
//            return getAuthor().isOnCommittee();
//        }


}
