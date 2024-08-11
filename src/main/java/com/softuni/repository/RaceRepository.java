package com.softuni.repository;

import com.softuni.domain.entities.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {

    List<Race> findAll();

    Optional<Race> findById(Long id);
}
