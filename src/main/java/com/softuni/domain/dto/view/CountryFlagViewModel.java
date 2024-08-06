package com.softuni.domain.dto.view;

import com.softuni.domain.entities.Track;

public class CountryFlagViewModel {

    private String name;
    private String countryFlagUrl;

    public CountryFlagViewModel() {
    }

    public CountryFlagViewModel(String name, String countryFlagUrl) {
        this.name = name;
        this.countryFlagUrl = countryFlagUrl;
    }

    public String getName() {
        return name;
    }

    public CountryFlagViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryFlagUrl() {
        return countryFlagUrl;
    }

    public CountryFlagViewModel setCountryFlagUrl(String countryFlagUrl) {
        this.countryFlagUrl = countryFlagUrl;
        return this;
    }

    public static CountryFlagViewModel getFromTrack(Track track) {
        return new CountryFlagViewModel(
                track.getCountry(),
                track.getCountryFlagUrl()
        );
    }
}
