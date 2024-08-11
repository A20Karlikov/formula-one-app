package com.softuni.domain.dto.forms;

import jakarta.validation.constraints.Size;

public class CommentForm {

    @Size(min = 5)
    private String text;

    public CommentForm() {
    }

    public @Size(min = 5) String getText() {
        return text;
    }

    public void setText(@Size(min = 5) String text) {
        this.text = text;
    }
}
