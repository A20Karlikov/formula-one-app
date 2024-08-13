package com.softuni.service;

import com.softuni.domain.dto.forms.AddNewRaceForm;
import com.softuni.domain.dto.forms.CommentForm;
import com.softuni.domain.dto.models.*;
import com.softuni.domain.dto.view.CommentViewModel;
import com.softuni.domain.dto.view.RaceHeaderViewModel;
import com.softuni.domain.dto.view.RaceViewModel;
import com.softuni.domain.entities.Comment;
import com.softuni.domain.entities.Race;
import com.softuni.domain.enums.WeatherType;
import com.softuni.helpers.LoggedUser;
import com.softuni.repository.CommentRepository;
import com.softuni.repository.DriverRepository;
import com.softuni.repository.RaceRepository;
import com.softuni.repository.TrackRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final CommentRepository commentRepository;
    private final DriverService driverService;
    private final TrackService trackService;
    private final ConstructorService constructorService;

    @Autowired
    public RaceService(RaceRepository raceRepository, UserService userService, ModelMapper modelMapper, LoggedUser loggedUser, CommentRepository commentRepository, DriverRepository driverRepository, DriverService driverService, TrackService trackService, ConstructorService constructorService) {
        this.raceRepository = raceRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.commentRepository = commentRepository;
        this.driverService = driverService;
        this.trackService = trackService;
        this.constructorService = constructorService;
    }

    public RaceViewModel getSelectedRace(Long id) {
        return this.raceRepository.findAll()
                .stream()
                .map(RaceViewModel::fromRace)
                .filter(raceViewModel -> raceViewModel.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<RaceHeaderViewModel> getRaceHeaders() {
        return this.raceRepository.findAll()
                .stream()
                .map(RaceHeaderViewModel::getFromRace)
                .toList();
    }

    public List<CommentViewModel> getSelectedRaceComments(Long id) {
        Race currentRace = this.raceRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return currentRace.getComments().stream().map(CommentViewModel::fromComment).toList();
    }

    public void addComment(CommentForm commentForm, Long raceId) {
        final CommentModel commentModel = this.modelMapper.map(commentForm, CommentModel.class);
        final UserModel user = this.userService.findByUsername(this.loggedUser.getUsername());
        final RaceModel race = this.modelMapper.map(this.getSelectedRace(raceId), RaceModel.class);

        commentModel
                .setCreated(LocalDateTime.now())
                .setRace(race)
                .setAuthor(user);

        final Comment commentToAdd = this.modelMapper.map(commentModel, Comment.class);

        this.modelMapper.map(this.commentRepository.saveAndFlush(commentToAdd), CommentModel.class);
    }

    public List<String> getRaceWeatherTypes() {
        return Arrays.stream(WeatherType.values()).map(Enum::name).toList();
    }

    public void addNewRace(AddNewRaceForm addNewRaceForm) {

        modelMapper.addMappings(new PropertyMap<AddNewRaceForm, RaceModel>() {
            @Override
            protected void configure() {
                skip(destination.getTrack());
                skip(destination.getWinner());
                skip(destination.getRunnerUp());
                skip(destination.getThirdPlace());
                skip(destination.getFastestLapHolder());
                skip(destination.getWeather());
                skip(destination.getComments());
            }
        });

        RaceModel raceModel = modelMapper.map(addNewRaceForm, RaceModel.class);
        raceModel.setTrack(this.modelMapper.map(this.trackService.getTrackByName(addNewRaceForm.getTrack()), TrackModel.class))
                .setWinner(this.modelMapper.map(this.driverService.getDriverDetails(addNewRaceForm.getWinner()), DriverModel.class))
                .setRunnerUp(this.modelMapper.map(this.driverService.getDriverDetails(addNewRaceForm.getRunnerUp()), DriverModel.class))
                .setThirdPlace(this.modelMapper.map(this.driverService.getDriverDetails(addNewRaceForm.getThirdPlace()), DriverModel.class))
                .setFastestLapHolder(this.modelMapper.map(this.driverService.getDriverDetails(addNewRaceForm.getFastestLapHolder()), DriverModel.class))
                .setWeather(WeatherType.valueOf(addNewRaceForm.getWeather()));

        this.driverService.addWinAndPodiumToDriver(addNewRaceForm.getWinner(), true);
        this.driverService.addWinAndPodiumToDriver(addNewRaceForm.getRunnerUp(), false);
        this.driverService.addWinAndPodiumToDriver(addNewRaceForm.getThirdPlace(), false);

        this.constructorService.addWinToConstructor(addNewRaceForm.getWinner());

        this.raceRepository.saveAndFlush(this.modelMapper.map(raceModel, Race.class));
    }
}
