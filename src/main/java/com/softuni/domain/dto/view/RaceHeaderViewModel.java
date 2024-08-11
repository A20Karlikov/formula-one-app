package com.softuni.domain.dto.view;

import com.softuni.domain.entities.Race;

public class RaceHeaderViewModel {

    private Long id;
    private String name;
    private String country;
    private String countryImageUrl;

    public RaceHeaderViewModel() {
    }

    public RaceHeaderViewModel(Long id, String name, String country, String countryImageUrl) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.countryImageUrl = countryImageUrl;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryImageUrl() {
        return countryImageUrl;
    }

    public void setCountryImageUrl(String countryImageUrl) {
        this.countryImageUrl = countryImageUrl;
    }

    public static RaceHeaderViewModel getFromRace(Race race) {
        return new RaceHeaderViewModel(
                race.getId(),
                race.getTrack().getName(),
                race.getTrack().getCountry(),
                race.getTrack().getCountryFlagUrl()
        );
    }
}
