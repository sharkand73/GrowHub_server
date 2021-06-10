package com.GrowHub.Server.models;


import com.GrowHub.Server.models.enums.Month;

import javax.persistence.*;

@Entity
@Table(name="tips")
public class Tip extends TextContent{

    @Column
    @Enumerated(value= EnumType.STRING)
    private Month month;

    //CONSTRUCTOR
    public Tip(String date, User author, String title, String body, Month month) {
        super(date, author, title, body);
        this.month = month;
    }

    public Tip(){}

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
