package com.softuni.repository;

import com.softuni.domain.entities.Role;
import com.softuni.domain.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByRole(RoleName role);

    List<Role> findAll();
}
