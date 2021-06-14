package com.GrowHub.Server.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "text_contents")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TextContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

//    @JsonBackReference
    @JsonIgnoreProperties(value = "text_contents")
    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private User author;

    @Column
    private String title;

    @Column
    private String body;

    //CONSTRUCTOR
    public TextContent(String date, User author, String title, String body) {
        this.date = date;
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public TextContent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
