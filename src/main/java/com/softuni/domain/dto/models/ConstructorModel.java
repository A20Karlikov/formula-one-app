package com.softuni.domain.dto.models;

import com.softuni.domain.enums.PowerUnitName;

import java.util.List;
import java.util.Set;

public class ConstructorModel {

    private Long id;
    private String name;
    private String fullTeamName;
    private String teamChief;
    private String profile;
    private Integer firstTeamEntry;
    private Integer worldTitles;
    private String carImageUrl;
    private String imageUrl;
    private Set<DriverModel> drivers;
    private PowerUnitName engine;
    private Integer numberOfWins;

    public ConstructorModel() {
    }

    public Long getId() {
        return id;
    }

    public ConstructorModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ConstructorModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getTeamChief() {
        return teamChief;
    }

    public ConstructorModel setTeamChief(String teamChief) {
        this.teamChief = teamChief;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ConstructorModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Set<DriverModel> getDrivers() {
        return drivers;
    }

    public ConstructorModel setDrivers(Set<DriverModel> drivers) {
        this.drivers = drivers;
        return this;
    }

    public PowerUnitName getEngine() {
        return engine;
    }

    public ConstructorModel setEngine(PowerUnitName engine) {
        this.engine = engine;
        return this;
    }

    public Integer getNumberOfWins() {
        return numberOfWins;
    }

    public ConstructorModel setNumberOfWins(Integer numberOfWins) {
        this.numberOfWins = numberOfWins;
        return this;
    }

    public String getFullTeamName() {
        return fullTeamName;
    }

    public void setFullTeamName(String fullTeamName) {
        this.fullTeamName = fullTeamName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getFirstTeamEntry() {
        return firstTeamEntry;
    }

    public void setFirstTeamEntry(Integer firstTeamEntry) {
        this.firstTeamEntry = firstTeamEntry;
    }

    public Integer getWorldTitles() {
        return worldTitles;
    }

    public void setWorldTitles(Integer worldTitles) {
        this.worldTitles = worldTitles;
    }

    public String getCarImageUrl() {
        return carImageUrl;
    }

    public void setCarImageUrl(String carImageUrl) {
        this.carImageUrl = carImageUrl;
    }
}
