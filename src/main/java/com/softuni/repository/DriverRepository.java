package com.softuni.repository;

import com.softuni.domain.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findAll();

    Optional<Driver> findByName(String name);

    @Query("SELECT d FROM Driver d WHERE d.numberOfWins = (SELECT MAX(d2.numberOfWins) FROM Driver d2)")
    List<Driver> findDriverWithMostWins();

    @Query("SELECT d FROM Driver d WHERE d.podiums = (SELECT MAX(d2.podiums) FROM Driver d2)")
    List<Driver> findDriverWithMostPodiums();

    @Query("SELECT d.country FROM Driver d GROUP BY d.country ORDER BY COUNT(d) DESC")
    List<String> findCountryWithMostDrivers();
}
