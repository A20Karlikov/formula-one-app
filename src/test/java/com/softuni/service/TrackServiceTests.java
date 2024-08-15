package com.softuni.service;

import com.softuni.domain.dto.view.CountryFlagViewModel;
import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.domain.dto.view.TrackViewModel;
import com.softuni.domain.entities.Driver;
import com.softuni.domain.entities.Track;
import com.softuni.repository.TrackRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TrackServiceTests {

    @InjectMocks
    private TrackService trackService;

    @Mock
    private TrackRepository trackRepository;

    private Track trackItaly;
    private Track trackAbuDhabi;
    List<Track> tracks = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        trackItaly = new Track() {{
            setId(1L);
            setCountry("Italy");
            setCountryFlagUrl("countryFlagUrl");
            setName("Monza");
            setFirstRace(1950);
            setNumberOfLaps(50);
            setImageUrl("imageUrl");
            setLapRecordHolder(Mockito.mock(Driver.class));
        }};

        trackAbuDhabi = new Track() {{
            setId(1L);
            setName("Marina Bey");
            setCountry("Abu Dhabi");
            setCountryFlagUrl("countryFlagUrl2");
            setFirstRace(2004);
            setNumberOfLaps(70);
            setImageUrl("imageUrl2");
            setLapRecordHolder(Mockito.mock(Driver.class));
        }};

        tracks.add(trackItaly);
        tracks.add(trackAbuDhabi);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void trackService_GetAllTracksTest() {
        // Arrange
        when(trackRepository.findAll()).thenReturn(tracks);

        // Act
        List<TrackViewModel> result = trackService.getAllTracks();

        // Assert
        assertNotNull(result);
        assertEquals(tracks.size(), result.size());

        assertEquals(tracks.get(0).getName(), result.get(0).getName());
        assertEquals(tracks.get(0).getNumberOfLaps(), result.get(0).getNumberOfLaps());

        assertEquals(tracks.get(1).getName(), result.get(1).getName());
        assertEquals(tracks.get(1).getNumberOfLaps(), result.get(1).getNumberOfLaps());
    }

    @Test
    public void trackService_GetSelectedTrackTest() {
        // Arrange
        TrackViewModel trackViewModel = TrackViewModel.fromTrack(trackItaly);

        when(trackRepository.findAll()).thenReturn(tracks);

        // Act
        TrackViewModel result = trackService.getSelectedTrack(trackItaly.getCountry());

        // Assert
        assertNotNull(result);
        assertEquals(trackItaly.getName(), result.getName());
        assertEquals(trackItaly.getNumberOfLaps(), result.getNumberOfLaps());
        assertEquals(trackItaly.getFirstRace(), result.getFirstRace());
    }

    @Test
    public void trackService_GetCountryFlagInfoTest() {
        // Arrange
        CountryFlagViewModel italyCountryFlag = CountryFlagViewModel.getFromTrack(trackItaly);
        CountryFlagViewModel abuDhabiCountryFlag = CountryFlagViewModel.getFromTrack(trackAbuDhabi);
        List<CountryFlagViewModel> expectedCountryFlags = List.of(italyCountryFlag, abuDhabiCountryFlag);

        when(trackRepository.findAll()).thenReturn(tracks);

        // Act
        List<CountryFlagViewModel> result = trackService.getCountryFlagsInfo();

        // Assert
        assertNotNull(result);
        assertEquals(expectedCountryFlags.get(0).getCountryFlagUrl(), result.get(0).getCountryFlagUrl());
        assertEquals(expectedCountryFlags.get(1).getCountryFlagUrl(), result.get(1).getCountryFlagUrl());
    }

    @Test
    public void trackService_GetTrackWithMostLapsTest() {
        // Arrange
        TrackViewModel expectedTrack = TrackViewModel.fromTrack(trackAbuDhabi);
        List<Track> tracksWithMostLaps = new ArrayList<>();
        tracksWithMostLaps.add(trackAbuDhabi);
        tracksWithMostLaps.add(trackItaly);

        when(trackRepository.findTrackWithMostLaps()).thenReturn(tracksWithMostLaps);

        // Act
        TrackViewModel result = trackService.getTrackWithMostLaps();

        // Assert
        assertNotNull(result);
        assertEquals(expectedTrack.getName(), result.getName());
        assertEquals(expectedTrack.getNumberOfLaps(), result.getNumberOfLaps());
    }

    @Test
    public void trackService_GetOldestTrackTest() {
        // Arrange
        TrackViewModel expectedTrack = TrackViewModel.fromTrack(trackItaly);
        List<Track> oldestTracks = new ArrayList<>();
        oldestTracks.add(trackItaly);
        oldestTracks.add(trackAbuDhabi);

        when(trackRepository.findOldestTrack()).thenReturn(oldestTracks);

        // Act
        TrackViewModel result = trackService.getOldestTrack();

        // Assert
        assertNotNull(result);
        assertEquals(expectedTrack.getName(), result.getName());
        assertEquals(expectedTrack.getFirstRace(), result.getFirstRace());
    }

    @Test
    public void trackService_GetTracksNamesTest() {
        // Arrange
        List<String> expectedTrackNames = List.of("Monza", "Marina Bey");

        when(trackRepository.findAll()).thenReturn(tracks);

        // Act
        List<String> result = trackService.getTracksNames();

        // Assert
        assertNotNull(result);
        assertEquals(expectedTrackNames.size(), result.size());

        assertEquals(expectedTrackNames.get(0), result.get(0));
        assertEquals(expectedTrackNames.get(1), result.get(1));
    }

    @Test
    public void tracksService_GetTrackByNameTest() {
        // Arrange
        when(trackRepository.findByName(trackAbuDhabi.getName())).thenReturn(Optional.of(trackAbuDhabi));

        // Act
        Track result = trackService.getTrackByName(trackAbuDhabi.getName());

        // Assert
        assertNotNull(result);
        assertEquals(trackAbuDhabi.getName(), result.getName());
        assertEquals(trackAbuDhabi.getNumberOfLaps(), result.getNumberOfLaps());
    }
}
