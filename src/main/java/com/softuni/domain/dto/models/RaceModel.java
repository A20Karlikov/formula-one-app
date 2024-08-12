package com.softuni.domain.dto.models;

import com.softuni.domain.enums.WeatherType;

import java.util.Set;

public class RaceModel {

    private Long id;
    private TrackModel track;
    private DriverModel winner;
    private DriverModel runnerUp;
    private DriverModel thirdPlace;
    private DriverModel fastestLapHolder;
    private WeatherType weather;
    private Set<CommentModel> comments;

    public RaceModel() {
    }

    public Long getId() {
        return id;
    }

    public RaceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public TrackModel getTrack() {
        return track;
    }

    public RaceModel setTrack(TrackModel track) {
        this.track = track;
        return this;
    }

    public DriverModel getWinner() {
        return winner;
    }

    public RaceModel setWinner(DriverModel winner) {
        this.winner = winner;
        return this;
    }

    public DriverModel getRunnerUp() {
        return runnerUp;
    }

    public RaceModel setRunnerUp(DriverModel runnerUp) {
        this.runnerUp = runnerUp;
        return this;
    }

    public DriverModel getThirdPlace() {
        return thirdPlace;
    }

    public RaceModel setThirdPlace(DriverModel thirdPlace) {
        this.thirdPlace = thirdPlace;
        return this;
    }

    public DriverModel getFastestLapHolder() {
        return fastestLapHolder;
    }

    public RaceModel setFastestLapHolder(DriverModel fastestLapHolder) {
        this.fastestLapHolder = fastestLapHolder;
        return this;
    }

    public WeatherType getWeather() {
        return weather;
    }

    public RaceModel setWeather(WeatherType weather) {
        this.weather = weather;
        return this;
    }

    public Set<CommentModel> getComments() {
        return comments;
    }

    public RaceModel setComments(Set<CommentModel> comments) {
        this.comments = comments;
        return this;
    }
}
