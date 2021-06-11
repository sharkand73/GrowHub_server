package com.GrowHub.Server.models;


import javax.persistence.*;

import com.GrowHub.Server.models.enums.Month;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

@Entity
@Table(name="know_hows")
public class Knowhow extends TextContent{

    @Column
    @Enumerated(value = EnumType.STRING)
    private Month month;

    //CONSTRUCTOR
    public Knowhow(String date, User author, String title, String body, Month month) {
        super(date, author, title, body);
        this.month = month;
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
}
