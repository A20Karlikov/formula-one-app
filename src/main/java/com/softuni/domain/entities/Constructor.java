package com.softuni.domain.entities;

import com.softuni.domain.enums.PowerUnitName;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "constructors")
public class Constructor extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column
    private String fullTeamName;

    @Column(nullable = false)
    private String teamChief;

    @Column(columnDefinition = "LONGTEXT")
    private String profile;

    @Column
    private Integer firstTeamEntry;

    @Column
    private Integer worldTitles;

    @Column(columnDefinition = "TEXT")
    private String carImageUrl;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Driver> drivers;

    @Enumerated(EnumType.STRING)
    private PowerUnitName engine;

    @Column
    private Integer numberOfWins;

    public Constructor() {
    }

    public String getName() {
        return name;
    }

    public Constructor setName(String name) {
        this.name = name;
        return this;
    }

    public String getTeamChief() {
        return teamChief;
    }

    public Constructor setTeamChief(String teamChief) {
        this.teamChief = teamChief;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Constructor setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public Constructor setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
        return this;
    }

    public PowerUnitName getEngine() {
        return engine;
    }

    public Constructor setEngine(PowerUnitName engine) {
        this.engine = engine;
        return this;
    }

    public Integer getNumberOfWins() {
        return numberOfWins;
    }

    public Constructor setNumberOfWins(Integer numberOfWins) {
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
