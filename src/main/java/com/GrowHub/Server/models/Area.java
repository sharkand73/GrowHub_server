package com.GrowHub.Server.models;

public abstract class Area {

    private Long id;
    private String areaName;

    public Area(String areaName) {
        this.areaName = areaName;
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
