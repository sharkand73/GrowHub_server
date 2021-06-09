package com.GrowHub.Server.models;

import com.GrowHub.Server.models.enums.AreaType;

import java.util.ArrayList;
import java.util.List;

public class Job extends TextContent{

    private AreaType area;
    private String deadline;
    private int difficulty;
    private List<User> users;

    public Job(Long id, String date, User author, String title, String body, AreaType area, String deadline, int difficulty) {
        super(id, date, author, title, body);
        this.area = area;
        this.deadline = deadline;
        this.difficulty = difficulty;
        this.users = new ArrayList<>();
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
