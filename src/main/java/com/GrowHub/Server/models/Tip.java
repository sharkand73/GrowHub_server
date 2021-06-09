package com.GrowHub.Server.models;

import com.GrowHub.Server.models.enums.Month;

public class Tip extends TextContent{

    private Month month;
    public Tip(Long id, String date, User author, String title, String body, Month month) {
        super(id, date, author, title, body);
        this.month = month;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
