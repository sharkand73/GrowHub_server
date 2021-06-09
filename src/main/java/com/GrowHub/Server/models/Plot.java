package com.GrowHub.Server.models;

import java.util.List;

public class Plot extends Area{

    private int plotNumber;
    private double length;
    private double breadth;
    private boolean isFlat;
    private List<Comment> comments;
    private List<User> users;

    public Plot(String areaName, int plotNumber, double length, double breadth, boolean isFlat) {
        super(areaName);
        this.plotNumber = plotNumber;
        this.length = length;
        this.breadth = breadth;
        this.isFlat = isFlat;
    }

    public int getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(int plotNumber) {
        this.plotNumber = plotNumber;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }

    public boolean isFlat() {
        return isFlat;
    }

    public void setFlat(boolean flat) {
        isFlat = flat;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
