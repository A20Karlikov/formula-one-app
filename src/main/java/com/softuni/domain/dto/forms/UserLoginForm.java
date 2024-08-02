package com.softuni.domain.dto.forms;

import com.softuni.validation.checkIfUserAlreadyExist.ValidateLoginForm;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@ValidateLoginForm
public class UserLoginForm {

    @NotNull
    @Size(min = 4)
    private String username;

    @NotNull
    @Size(min = 5)
    private String password;

    public UserLoginForm() {
    }

    public @NotNull String getUsername() {
        return username;
    }

    public UserLoginForm setUsername(@NotNull String username) {
        this.username = username;
        return this;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public UserLoginForm setPassword(@NotNull String password) {
        this.password = password;
        return this;
    }
}
