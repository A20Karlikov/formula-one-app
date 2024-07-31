package com.softuni.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column
    private LocalDateTime created;

    @Column(columnDefinition = "TEXT", name = "text_content")
    private String text;

    @ManyToOne
    private User author;

    @ManyToOne
    private Race race;

    public Comment() {
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Comment setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getText() {
        return text;
    }

    public Comment setText(String text) {
        this.text = text;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Race getRace() {
        return race;
    }

    public Comment setRace(Race race) {
        this.race = race;
        return this;
    }
}
