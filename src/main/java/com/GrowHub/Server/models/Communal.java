package com.GrowHub.Server.models;

import com.GrowHub.Server.models.enums.AreaType;

import java.util.ArrayList;

public class Communal extends Area{

    private AreaType areaType;
    private ArrayList<Integer> plotNumbers;
    private String areaInfo;

    public Communal(String areaName, AreaType areaType, ArrayList<Integer> plotNumbers, String areaInfo) {
        super(areaName);
        this.areaType = areaType;
        this.plotNumbers = plotNumbers;
        this.areaInfo = areaInfo;
    }

    public AreaType getAreaType() {
        return areaType;
    }

    public void setAreaType(AreaType areaType) {
        this.areaType = areaType;
    }

    public ArrayList<Integer> getPlotNumbers() {
        return plotNumbers;
    }

    public void setPlotNumbers(ArrayList<Integer> plotNumbers) {
        this.plotNumbers = plotNumbers;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo;
    }
}
