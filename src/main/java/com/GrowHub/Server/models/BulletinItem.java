package com.GrowHub.Server.models;

public class BulletinItem extends TextContent{

    public BulletinItem(Long id, String date, User author, String title, String body) {
        super(id, date, author, title, body);

    }
        public boolean isFromCommittee(){
            return getAuthor().isOnCommittee();
        }

}
