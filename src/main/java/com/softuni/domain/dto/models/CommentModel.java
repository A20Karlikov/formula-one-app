package com.softuni.domain.dto.models;

import java.time.LocalDateTime;

public class CommentModel {

    private Long id;
    private LocalDateTime created;
    private String text;
    private UserModel author;
    private RaceModel race;

    public CommentModel() {
    }

    public Long getId() {
        return id;
    }

    public CommentModel setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public CommentModel setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getText() {
        return text;
    }

    public CommentModel setText(String text) {
        this.text = text;
        return this;
    }

    public UserModel getAuthor() {
        return author;
    }

    public CommentModel setAuthor(UserModel author) {
        this.author = author;
        return this;
    }

    public RaceModel getRace() {
        return race;
    }

    public CommentModel setRace(RaceModel race) {
        this.race = race;
        return this;
    }
}
