package com.softuni.service;

import com.softuni.domain.dto.view.CountryFlagViewModel;
import com.softuni.domain.dto.view.TrackViewModel;
import com.softuni.domain.entities.Track;
import com.softuni.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public TrackViewModel getSelectedTrack(String name) {
        return streamTracks()
                .map(TrackViewModel::fromTrack)
                .filter(trackViewModel -> trackViewModel.getCountry().equals(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<TrackViewModel> getAllTracks() {
        return streamTracks().map(TrackViewModel::fromTrack).toList();
    }

    public List<CountryFlagViewModel> getCountryFlagsInfo() {
        return streamTracks().map(CountryFlagViewModel::getFromTrack).toList();
    }

    private Stream<Track> streamTracks() {
        return this.trackRepository.findAll().stream();
    }

    public TrackViewModel getTrackWithMostLaps() {
        return this.trackRepository
                .findTrackWithMostLaps()
                .stream()
                .map(TrackViewModel::fromTrack)
                .toList().get(0);
    }

    public TrackViewModel getOldestTrack() {
        return this.trackRepository
                .findOldestTrack()
                .stream()
                .map(TrackViewModel::fromTrack)
                .toList().get(0);
    }

    public List<String> getTracksNames() {
        return this.trackRepository.findAll().stream().map(Track::getName).toList();
    }

    public Track getTrackByName(String name) {
        return this.trackRepository.findByName(name).orElseThrow(NoSuchElementException::new);
    }
}
