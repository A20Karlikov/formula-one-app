package com.softuni.domain.dto.models;

import com.softuni.domain.enums.DriverLevel;

public class DriverModel {

    private Long id;
    private String name;
    private String country;
    private DriverLevel level;
    private String description;
    private String imageUrl;
    private Integer numberOfWins;
    private Integer podiums;
    private Integer raceNumber;
    private ConstructorModel constructor;

    public DriverModel() {
    }

    public Long getId() {
        return id;
    }

    public DriverModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DriverModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public DriverModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public DriverLevel getLevel() {
        return level;
    }

    public DriverModel setLevel(DriverLevel level) {
        this.level = level;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public DriverModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getNumberOfWins() {
        return numberOfWins;
    }

    public DriverModel setNumberOfWins(Integer numberOfWins) {
        this.numberOfWins = numberOfWins;
        return this;
    }

    public Integer getPodiums() {
        return podiums;
    }

    public void setPodiums(Integer podiums) {
        this.podiums = podiums;
    }

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public DriverModel setRaceNumber(Integer raceNumber) {
        this.raceNumber = raceNumber;
        return this;
    }

    public ConstructorModel getConstructor() {
        return constructor;
    }

    public DriverModel setConstructor(ConstructorModel constructor) {
        this.constructor = constructor;
        return this;
    }
}
