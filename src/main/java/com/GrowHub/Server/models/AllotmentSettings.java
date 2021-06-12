package com.GrowHub.Server.models;

import javax.persistence.*;

@Entity
@Table(name="settings")
public class AllotmentSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String location;

    @Column(name="country_code")
    private String countryCode;

    @Column
    private String coordinates;

    @Column(name="api_key")
    private String APIKey;

    @Column(name="map_filepath")
    private String mapFilepath;

    public AllotmentSettings(String name, String location, String countryCode, String coordinates, String APIKey, String mapFilepath) {
        this.name = name;
        this.location = location;
        this.countryCode = countryCode;
        this.coordinates = coordinates;
        this.APIKey = APIKey;
        this.mapFilepath = mapFilepath;
        this.id = id;
    }

    public AllotmentSettings() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getAPIKey() {
        return APIKey;
    }

    public void setAPIKey(String APIKey) {
        this.APIKey = APIKey;
    }

    public String getMapFilepath() {
        return mapFilepath;
    }

    public void setMapFilepath(String mapFilepath) {
        this.mapFilepath = mapFilepath;
    }
}
