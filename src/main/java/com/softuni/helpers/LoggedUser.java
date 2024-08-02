package com.softuni.helpers;

import com.softuni.domain.dto.models.RoleModel;
import com.softuni.domain.enums.RoleName;

import java.util.Set;

public class LoggedUser {

    private Long id;
    private String username;
    private Set<RoleModel> roles;

    public LoggedUser() {
    }

    public Long getId() {
        return id;
    }

    public LoggedUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public LoggedUser setRoles(Set<RoleModel> roles) {
        this.roles = roles;
        return this;
    }

    public void clearFields() {
        this.id = null;
        this.username = null;
        this.roles = null;
    }

    public Boolean isAdmin() {
        return roles.stream().anyMatch(roleModel -> roleModel.getRole().equals(RoleName.ADMIN));
    }
}
