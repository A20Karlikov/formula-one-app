package com.softuni.domain.dto.view;

import com.softuni.domain.entities.Constructor;
import com.softuni.domain.entities.Driver;
import com.softuni.domain.enums.PowerUnitName;

import java.util.List;
import java.util.Set;

public class ConstructorViewModel {

    private Long id;
    private String name;
    private String fullTeamName;
    private String teamChief;
    private String profile;
    private Integer firstTeamEntry;
    private Integer worldTitles;
    private String carImageUrl;
    private String imageUrl;
    private PowerUnitName engine;
    private Integer numberOfWins;

    public ConstructorViewModel() {
    }

    public ConstructorViewModel(
            Long id,
            String name,
            String fullTeamName,
            String teamChief,
            String profile,
            Integer firstTeamEntry,
            Integer worldTitles,
            String carImageUrl,
            String imageUrl,
            PowerUnitName engine,
            Integer numberOfWins
    ) {
        this.id = id;
        this.name = name;
        this.fullTeamName = fullTeamName;
        this.teamChief = teamChief;
        this.profile = profile;
        this.firstTeamEntry = firstTeamEntry;
        this.worldTitles = worldTitles;
        this.carImageUrl = carImageUrl;
        this.imageUrl = imageUrl;
        this.engine = engine;
        this.numberOfWins = numberOfWins;
    }

    public Long getId() {
        return id;
    }

    public ConstructorViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ConstructorViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getTeamChief() {
        return teamChief;
    }

    public ConstructorViewModel setTeamChief(String teamChief) {
        this.teamChief = teamChief;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ConstructorViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public PowerUnitName getEngine() {
        return engine;
    }

    public ConstructorViewModel setEngine(PowerUnitName engine) {
        this.engine = engine;
        return this;
    }

    public Integer getNumberOfWins() {
        return numberOfWins;
    }

    public ConstructorViewModel setNumberOfWins(Integer numberOfWins) {
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

    public static ConstructorViewModel fromConstructor(Constructor constructor) {
        return new ConstructorViewModel(
                constructor.getId(),
                constructor.getName(),
                constructor.getFullTeamName(),
                constructor.getTeamChief(),
                constructor.getProfile(),
                constructor.getFirstTeamEntry(),
                constructor.getWorldTitles(),
                constructor.getCarImageUrl(),
                constructor.getImageUrl(),
                constructor.getEngine(),
                constructor.getNumberOfWins()
        );
    }
}
