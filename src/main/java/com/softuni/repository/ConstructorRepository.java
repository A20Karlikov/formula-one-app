package com.softuni.repository;

import com.softuni.domain.entities.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {

    List<Constructor> findAll();

    Optional<Constructor> findByName(String name);
}
