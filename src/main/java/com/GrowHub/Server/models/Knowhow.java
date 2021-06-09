package com.GrowHub.Server.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Knowhow extends TextContent{

    public Knowhow(Long id, String date, User author, String title, String body) {
        super(id, date, author, title, body);
    }

    public String getMonth(){
        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String[] splitDate = getDate().split("-");
        int monthIndex = parseInt(splitDate[1]) - 1;
        return months.get(monthIndex);
    }

}
