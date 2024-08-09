package com.softuni.repository;

import com.softuni.domain.entities.Constructor;
import com.softuni.domain.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor, Long> {

    List<Constructor> findAll();

    Optional<Constructor> findByName(String name);

    @Query("SELECT c FROM Constructor c WHERE c.numberOfWins = (SELECT MAX(c2.numberOfWins) FROM Constructor c2)")
    List<Constructor> findConstructorWithMostWins();

    @Query("SELECT c FROM Constructor c WHERE c.worldTitles = (SELECT MAX(c2.worldTitles) FROM Constructor c2)")
    List<Constructor> findConstructorWithMostTitles();

    @Query("SELECT c FROM Constructor c ORDER BY c.firstTeamEntry ASC")
    List<Constructor> findOldestTeam();

    @Query("SELECT c FROM Constructor c ORDER BY c.firstTeamEntry DESC")
    List<Constructor> findYoungestTeam();
}
