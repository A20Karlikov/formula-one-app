package com.softuni.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tracks")
public class Track extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Column
    private Integer firstRace;

    @Column
    private Integer numberOfLaps;

    @OneToOne
    private Driver lapRecordHolder;

    public Track() {
    }

    public String getName() {
        return name;
    }

    public Track setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Track setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Track setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getFirstRace() {
        return firstRace;
    }

    public Track setFirstRace(Integer firstRace) {
        this.firstRace = firstRace;
        return this;
    }

    public Integer getNumberOfLaps() {
        return numberOfLaps;
    }

    public Track setNumberOfLaps(Integer numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
        return this;
    }

    public Driver getLapRecordHolder() {
        return lapRecordHolder;
    }

    public Track setLapRecordHolder(Driver lapRecordHolder) {
        this.lapRecordHolder = lapRecordHolder;
        return this;
    }
}
