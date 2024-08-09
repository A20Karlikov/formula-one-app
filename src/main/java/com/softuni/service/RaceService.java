package com.softuni.service;

import com.softuni.domain.dto.view.RaceHeaderViewModel;
import com.softuni.domain.dto.view.RaceViewModel;
import com.softuni.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
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
}
