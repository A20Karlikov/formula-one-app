package com.softuni.domain.dto.view;

import com.softuni.domain.dto.models.DriverModel;
import com.softuni.domain.entities.Track;

public class TrackViewModel {

    private Long id;
    private String name;
    private String country;
    private String countryFlagUrl;
    private String imageUrl;
    private Integer firstRace;
    private Integer numberOfLaps;
    private String lapRecord;
    private String lapRecordHolder;

    public TrackViewModel() {
    }

    public TrackViewModel(Long id, String name, String country, String countryFlagUrl, String imageUrl, Integer firstRace, Integer numberOfLaps, String lapRecord, String lapRecordHolder) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.countryFlagUrl = countryFlagUrl;
        this.imageUrl = imageUrl;
        this.firstRace = firstRace;
        this.numberOfLaps = numberOfLaps;
        this.lapRecord = lapRecord;
        this.lapRecordHolder = lapRecordHolder;
    }

    public Long getId() {
        return id;
    }

    public TrackViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TrackViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public TrackViewModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryFlagUrl() {
        return countryFlagUrl;
    }

    public TrackViewModel setCountryFlagUrl(String countryFlagUrl) {
        this.countryFlagUrl = countryFlagUrl;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TrackViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getFirstRace() {
        return firstRace;
    }

    public TrackViewModel setFirstRace(Integer firstRace) {
        this.firstRace = firstRace;
        return this;
    }

    public Integer getNumberOfLaps() {
        return numberOfLaps;
    }

    public TrackViewModel setNumberOfLaps(Integer numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
        return this;
    }

    public String getLapRecord() {
        return lapRecord;
    }

    public TrackViewModel setLapRecord(String lapRecord) {
        this.lapRecord = lapRecord;
        return this;
    }

    public String getLapRecordHolder() {
        return lapRecordHolder;
    }

    public TrackViewModel setLapRecordHolder(String lapRecordHolder) {
        this.lapRecordHolder = lapRecordHolder;
        return this;
    }

    public static TrackViewModel fromTrack(Track track) {
        return new TrackViewModel(
                track.getId(),
                track.getName(),
                track.getCountry(),
                track.getCountryFlagUrl(),
                track.getImageUrl(),
                track.getFirstRace(),
                track.getNumberOfLaps(),
                track.getLapRecord(),
                track.getLapRecordHolder().getName()
        );
    }
}
