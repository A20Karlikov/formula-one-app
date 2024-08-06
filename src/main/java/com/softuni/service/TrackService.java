package com.softuni.service;

import com.softuni.domain.dto.view.CountryFlagViewModel;
import com.softuni.domain.dto.view.TrackViewModel;
import com.softuni.domain.entities.Track;
import com.softuni.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public TrackViewModel getSelectedTrack(String countryName) {
        return streamTracks()
                .map(TrackViewModel::fromTrack)
                .filter(trackViewModel -> trackViewModel.getCountry().equals(countryName))
                .findFirst().get();
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
}
