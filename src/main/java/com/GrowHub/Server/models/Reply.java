package com.GrowHub.Server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

@Entity
@Table(name = "replies")
public class Reply {

//    Need to add another type here, if we want replies on bulletins to be allowed
    @JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Knowhow.class, name = "knowHow"),
            @JsonSubTypes.Type(value = Job.class, name = "job")
    })

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String body;

    @Column
    private String date;

    @JsonIgnoreProperties(value = "replies")
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @JsonIgnoreProperties(value = "replies")
    @ManyToOne
    @JoinColumn(name = "textContent_id", nullable = false)
    private TextContent textContent;

    public Reply(String body, String date, User author, TextContent textContent) {
        this.body = body;
        this.date = date;
        this.author = author;
        this.textContent = textContent;
    }

    public Reply() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public TextContent getTextContent() {
        return textContent;
    }

    public void setTextContent(TextContent textContent) {
        this.textContent = textContent;
    }
}
