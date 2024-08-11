package com.softuni.domain.dto.view;

import com.softuni.domain.entities.Comment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentViewModel {

    private String author;
    private String dateCreated;
    private String text;

    public CommentViewModel() {
    }

    public CommentViewModel(String author, String dateCreated, String text) {
        this.author = author;
        this.dateCreated = dateCreated;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static CommentViewModel fromComment(Comment comment) {
        return new CommentViewModel(
                comment.getAuthor().getUsername(),
                comment.getCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                comment.getText()
        );
    }
}
