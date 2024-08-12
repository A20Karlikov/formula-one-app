package com.softuni.domain.dto.forms;

import com.softuni.validation.podiumMatcher.PodiumMatch;

@PodiumMatch(winner = "winner", runnerUp = "runnerUp", thirdPlace = "thirdPlace")
public class AddNewRaceForm {

    private String track;
    private String winner;
    private String runnerUp;
    private String thirdPlace;
    private String fastestLapHolder;
    private String weather;

    public AddNewRaceForm() {
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getRunnerUp() {
        return runnerUp;
    }

    public void setRunnerUp(String runnerUp) {
        this.runnerUp = runnerUp;
    }

    public String getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(String thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public String getFastestLapHolder() {
        return fastestLapHolder;
    }

    public void setFastestLapHolder(String fastestLapHolder) {
        this.fastestLapHolder = fastestLapHolder;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
