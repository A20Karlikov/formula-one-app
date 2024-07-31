package com.softuni.domain.dto.models;

public class TrackModel {

    private Long id;
    private String name;
    private String country;
    private String imageUrl;
    private Integer firstRace;
    private Integer numberOfLaps;
    private DriverModel lapRecordHolder;

    public TrackModel() {
    }

    public Long getId() {
        return id;
    }

    public TrackModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TrackModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public TrackModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TrackModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getFirstRace() {
        return firstRace;
    }

    public TrackModel setFirstRace(Integer firstRace) {
        this.firstRace = firstRace;
        return this;
    }

    public Integer getNumberOfLaps() {
        return numberOfLaps;
    }

    public TrackModel setNumberOfLaps(Integer numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
        return this;
    }

    public DriverModel getLapRecordHolder() {
        return lapRecordHolder;
    }

    public TrackModel setLapRecordHolder(DriverModel lapRecordHolder) {
        this.lapRecordHolder = lapRecordHolder;
        return this;
    }
}
