package com.softuni.domain.entities;

import com.softuni.domain.enums.DriverLevel;
import jakarta.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Enumerated(EnumType.STRING)
    private DriverLevel level;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Column
    private Integer numberOfWins;

    @Column(nullable = false)
    private Integer raceNumber;

    @OneToOne()
    private Constructor constructor;

    public Driver() {
    }

    public String getName() {
        return name;
    }

    public Driver setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Driver setCountry(String country) {
        this.country = country;
        return this;
    }

    public DriverLevel getLevel() {
        return level;
    }

    public Driver setLevel(DriverLevel level) {
        this.level = level;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Driver setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getNumberOfWins() {
        return numberOfWins;
    }

    public Driver setNumberOfWins(Integer numberOfWins) {
        this.numberOfWins = numberOfWins;
        return this;
    }

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public Driver setRaceNumber(Integer raceNumber) {
        this.raceNumber = raceNumber;
        return this;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public Driver setConstructor(Constructor constructor) {
        this.constructor = constructor;
        return this;
    }
}
