package com.softuni.domain.dto.models;

import java.util.Set;

public class UserModel {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private Set<RoleModel> roles;

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public UserModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public UserModel setRoles(Set<RoleModel> roles) {
        this.roles = roles;
        return this;
    }

    public boolean isValid() {
        return this.id != null;
    }
}
