package com.GrowHub.Server.models;

public class Comment extends TextContent{

    public Comment(Long id, String date, User author, String title, String body) {
        super(id, date, author, title, body);
    }
}
