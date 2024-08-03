package com.softuni.domain.dto.view;

import com.softuni.domain.entities.Constructor;
import com.softuni.domain.enums.PowerUnitName;

public class ConstructorViewModel {

    private Long id;
    private String name;
    private String teamChief;
    private String imageUrl;
    private PowerUnitName engine;
    private Integer numberOfWins;

    public ConstructorViewModel() {
    }

    public ConstructorViewModel(Long id, String name, String teamChief, String imageUrl, PowerUnitName engine, Integer numberOfWins) {
        this.id = id;
        this.name = name;
        this.teamChief = teamChief;
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

    public static ConstructorViewModel fromConstructor(Constructor constructor) {
        return new ConstructorViewModel(
                constructor.getId(),
                constructor.getName(),
                constructor.getTeamChief(),
                constructor.getImageUrl(),
                constructor.getEngine(),
                constructor.getNumberOfWins()
        );
    }
}
