package com.GrowHub.Server.models;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Comment extends TextContent{

    public Comment(String date, User author, String title, String body) {
        super(date, author, title, body);
    }

    public Comment() {
    }

}
