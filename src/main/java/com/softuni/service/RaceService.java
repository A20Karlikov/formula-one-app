package com.softuni.service;

import com.softuni.domain.dto.forms.CommentForm;
import com.softuni.domain.dto.models.CommentModel;
import com.softuni.domain.dto.models.RaceModel;
import com.softuni.domain.dto.models.UserModel;
import com.softuni.domain.dto.view.CommentViewModel;
import com.softuni.domain.dto.view.RaceHeaderViewModel;
import com.softuni.domain.dto.view.RaceViewModel;
import com.softuni.domain.entities.Comment;
import com.softuni.domain.entities.Driver;
import com.softuni.domain.entities.Race;
import com.softuni.domain.enums.WeatherType;
import com.softuni.helpers.LoggedUser;
import com.softuni.repository.CommentRepository;
import com.softuni.repository.RaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final CommentRepository commentRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository, UserService userService, ModelMapper modelMapper, LoggedUser loggedUser, CommentRepository commentRepository) {
        this.raceRepository = raceRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.commentRepository = commentRepository;
    }

    public RaceViewModel getSelectedRace(Long id) {
        return this.raceRepository.findAll()
                .stream()
                .map(RaceViewModel::fromRace)
                .filter(raceViewModel -> raceViewModel.getId().equals(id))
                .findFirst().get();
    }

    public List<RaceHeaderViewModel> getRaceHeaders() {
        return this.raceRepository.findAll()
                .stream()
                .map(RaceHeaderViewModel::getFromRace)
                .toList();
    }

    public List<CommentViewModel> getSelectedRaceComments(Long id) {
        Race currentRace = this.raceRepository.findById(id).get();

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
}
