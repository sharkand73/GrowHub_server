package com.GrowHub.Server.models;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Comment extends TextContent{

    public Comment(Long id, String date, User author, String title, String body) {
        super(id, date, author, title, body);
    }

    public Comment() {
    }

}
