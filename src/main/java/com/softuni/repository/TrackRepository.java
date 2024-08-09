package com.softuni.repository;

import com.softuni.domain.entities.Constructor;
import com.softuni.domain.entities.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findAll();

    @Query("SELECT t FROM Track t WHERE t.numberOfLaps = (SELECT MAX(t2.numberOfLaps) FROM Track t2)")
    List<Track> findTrackWithMostLaps();

    @Query("SELECT t FROM Track t ORDER BY t.firstRace ASC")
    List<Track> findOldestTrack();
}
