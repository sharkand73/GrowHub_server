package com.GrowHub.Server.models;


import javax.persistence.*;

import com.GrowHub.Server.models.enums.Month;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

@Entity
@Table(name="knowhows")
public class Knowhow extends TextContent{

    @Column
    @Enumerated(value = EnumType.STRING)
    private Month month;

    @JsonIgnoreProperties({"knowhows", "email", "password", "yearJoined", "yearLeft", "plots", "crops"})
//    @JsonBackReference(value="know_hows")
    @ManyToOne
    @JoinColumn(name="author_id", nullable = false)
    private User author;

    @JsonIgnoreProperties({"knowhow", "email", "password", "yearJoined", "yearLeft", "plots", "crops"})
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "knowhow", fetch = FetchType.LAZY)
    private List<Reply> replies;

    //CONSTRUCTOR
    public Knowhow(String date, User author, String title, String body, Month month) {
        super(date, title, body);
        this.month = month;
        this.author = author;
        this.replies = new ArrayList<>();
    }

    public Knowhow() {

    }

//    public String getMonth(){
//        List<String> months = Arrays.asList(
//                "January", "February", "March", "April", "May", "June",
//                "July", "August", "September", "October", "November", "December");
//        String[] splitDate = getDate().split("-");
//        int monthIndex = parseInt(splitDate[1]) - 1;
//        return months.get(monthIndex);
//    }


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

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
