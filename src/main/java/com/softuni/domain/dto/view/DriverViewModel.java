package com.softuni.domain.dto.view;

import com.softuni.domain.entities.Driver;
import com.softuni.domain.enums.DriverLevel;

public class DriverViewModel {

    private Long id;
    private String name;
    private String country;
    private DriverLevel level;
    private String imageUrl;
    private Integer numberOfWins;
    private Integer raceNumber;
    private String constructorName;

    public DriverViewModel() {
    }

    public DriverViewModel(Long id, String name, String country, DriverLevel level, String imageUrl, Integer numberOfWins, Integer raceNumber, String constructorName) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.level = level;
        this.imageUrl = imageUrl;
        this.numberOfWins = numberOfWins;
        this.raceNumber = raceNumber;
        this.constructorName = constructorName;
    }

    public Long getId() {
        return id;
    }

    public DriverViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DriverViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public DriverViewModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public DriverLevel getLevel() {
        return level;
    }

    public DriverViewModel setLevel(DriverLevel level) {
        this.level = level;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public DriverViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getNumberOfWins() {
        return numberOfWins;
    }

    public DriverViewModel setNumberOfWins(Integer numberOfWins) {
        this.numberOfWins = numberOfWins;
        return this;
    }

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public DriverViewModel setRaceNumber(Integer raceNumber) {
        this.raceNumber = raceNumber;
        return this;
    }

    public String getConstructorName() {
        return constructorName;
    }

    public DriverViewModel setConstructorName(String constructorName) {
        this.constructorName = constructorName;
        return this;
    }

    public static DriverViewModel fromDriver(Driver driver) {
        return new DriverViewModel(
                driver.getId(),
                driver.getName(),
                driver.getCountry(),
                driver.getLevel(),
                driver.getImageUrl(),
                driver.getNumberOfWins(),
                driver.getRaceNumber(),
                driver.getConstructor().getName()
        );
    }
}