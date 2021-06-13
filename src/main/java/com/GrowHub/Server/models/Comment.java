package com.GrowHub.Server.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Comment extends TextContent{


    @JsonIgnoreProperties(value="comments")
    @ManyToOne
    @JoinColumn(name="plot_id", nullable = false)
    private Plot plot;

    //CONSTRUCTOR
    public Comment(String date, User author, String title, String body, Plot plot) {
        super(date, author, title, body);
        this.plot = plot;
    }

    public Comment() {
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }
}
