package com.softuni.domain.dto.forms;

import com.softuni.validation.checkIfUsernameIsOccupied.ValidateRegisterForm;
import com.softuni.validation.passwordMatcher.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@ValidateRegisterForm(username = "username")
@PasswordMatch(password = "password", confirmPassword = "confirmPassword")
public class UserRegisterForm {

    @NotNull
    @Size(min = 4, max = 20)
    private String username;

    @Email
    private String email;

    @NotNull
    private Integer age;

    @NotNull
    @Size(min = 5, max = 20)
    private String password;

    @NotNull
    @Size(min = 5, max = 20)
    private String confirmPassword;

    public UserRegisterForm() {
    }

    public @NotNull @Size(min = 4, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull @Size(min = 4, max = 20) String username) {
        this.username = username;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotNull Integer getAge() {
        return age;
    }

    public void setAge(@NotNull Integer age) {
        this.age = age;
    }

    public @NotNull @Size(min = 5, max = 20) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 5, max = 20) String password) {
        this.password = password;
    }

    public @NotNull @Size(min = 5, max = 20) String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@NotNull @Size(min = 5, max = 20) String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
