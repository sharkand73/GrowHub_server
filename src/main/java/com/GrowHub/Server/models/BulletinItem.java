package com.GrowHub.Server.models;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class BulletinItem extends TextContent{

    //CONSTRUCTOR
    public BulletinItem(String date, User author, String title, String body) {
        super(date, author, title, body);

    }

    public BulletinItem() {
    }

    public boolean isFromCommittee(){
            return getAuthor().isOnCommittee();
        }

}
