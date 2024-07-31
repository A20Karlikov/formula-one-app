package com.softuni.domain.entities;

import com.softuni.domain.enums.WeatherType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "races")
public class Race extends BaseEntity {

    @OneToOne
    private Track track;

    @OneToOne
    private Driver winner;

    @OneToOne
    private Driver fastestLapHolder;

    @Enumerated(EnumType.STRING)
    private WeatherType weather;

    @OneToMany(targetEntity = Comment.class,
            mappedBy = "race",
            cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Set<Comment> comments;

    public Race() {
    }

    public Track getTrack() {
        return track;
    }

    public Race setTrack(Track track) {
        this.track = track;
        return this;
    }

    public Driver getWinner() {
        return winner;
    }

    public Race setWinner(Driver winner) {
        this.winner = winner;
        return this;
    }

    public Driver getFastestLapHolder() {
        return fastestLapHolder;
    }

    public Race setFastestLapHolder(Driver fastestLapHolder) {
        this.fastestLapHolder = fastestLapHolder;
        return this;
    }

    public WeatherType getWeather() {
        return weather;
    }

    public Race setWeather(WeatherType weather) {
        this.weather = weather;
        return this;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Race setComments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }
}
