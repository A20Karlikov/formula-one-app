package com.softuni.domain.dto.view;

import com.softuni.domain.entities.Race;
import com.softuni.domain.enums.WeatherType;

public class RaceViewModel {

    private Long id;
    private String winner;
    private String winnerImage;
    private String runnerUp;
    private String runnerUpImage;
    private String thirdPlace;
    private String thirdPlaceImage;
    private WeatherType weather;
    private String trackName;
    private String trackCountryImage;

    public RaceViewModel() {
    }

    public RaceViewModel(
            Long id,
            String winner,
            String winnerImage,
            String runnerUp,
            String runnerUpImage,
            String thirdPlace,
            String thirdPlaceImage,
            WeatherType weather,
            String trackName,
            String trackCountryImage
    ) {
        this.id = id;
        this.winner = winner;
        this.winnerImage = winnerImage;
        this.runnerUp = runnerUp;
        this.runnerUpImage = runnerUpImage;
        this.thirdPlace = thirdPlace;
        this.thirdPlaceImage = thirdPlaceImage;
        this.weather = weather;
        this.trackName = trackName;
        this.trackCountryImage = trackCountryImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getWinnerImage() {
        return winnerImage;
    }

    public void setWinnerImage(String winnerImage) {
        this.winnerImage = winnerImage;
    }

    public String getRunnerUp() {
        return runnerUp;
    }

    public void setRunnerUp(String runnerUp) {
        this.runnerUp = runnerUp;
    }

    public String getRunnerUpImage() {
        return runnerUpImage;
    }

    public void setRunnerUpImage(String runnerUpImage) {
        this.runnerUpImage = runnerUpImage;
    }

    public String getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(String thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public String getThirdPlaceImage() {
        return thirdPlaceImage;
    }

    public void setThirdPlaceImage(String thirdPlaceImage) {
        this.thirdPlaceImage = thirdPlaceImage;
    }

    public WeatherType getWeather() {
        return weather;
    }

    public void setWeather(WeatherType weather) {
        this.weather = weather;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackCountryImage() {
        return trackCountryImage;
    }

    public void setTrackCountryImage(String trackCountryImage) {
        this.trackCountryImage = trackCountryImage;
    }

    public static RaceViewModel fromRace(Race race) {
        return new RaceViewModel(
                race.getId(),
                race.getWinner().getName(),
                race.getWinner().getImageUrl(),
                race.getRunnerUp().getName(),
                race.getRunnerUp().getImageUrl(),
                race.getThirdPlace().getName(),
                race.getThirdPlace().getImageUrl(),
                race.getWeather(),
                race.getTrack().getName(),
                race.getTrack().getCountryFlagUrl()
        );
    }

    public Boolean isSunny() {
        return weather.name().equals(WeatherType.SUNNY.name());
    }

    public Boolean isRainy() {
        return weather.name().equals(WeatherType.RAINY.name());
    }

    public Boolean isCloudy() {
        return weather.name().equals(WeatherType.CLOUDY.name());
    }
}
