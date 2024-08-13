package com.softuni.service;

import com.softuni.domain.dto.models.ConstructorModel;
import com.softuni.domain.dto.view.ConstructorViewModel;
import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.domain.entities.Constructor;
import com.softuni.repository.ConstructorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ConstructorService {

    private final ConstructorRepository constructorRepository;
    private final ModelMapper modelMapper;
    private final DriverService driverService;

    @Autowired
    public ConstructorService(
            ConstructorRepository constructorRepository,
            ModelMapper modelMapper, DriverService driverService
    ) {
        this.constructorRepository = constructorRepository;
        this.modelMapper = modelMapper;
        this.driverService = driverService;
    }

    public List<ConstructorViewModel> getAllConstructors() {
        return this.constructorRepository
                .findAll()
                .stream()
                .map(ConstructorViewModel::fromConstructor)
                .toList();
    }

    public ConstructorViewModel getConstructorByName(String name) {
        return  this.modelMapper.map(this.constructorRepository.findByName(name), ConstructorViewModel.class);
    }

    public List<DriverViewModel> getTeamDrivers(String name) {
        return this.constructorRepository.findByName(name)
                .orElseThrow(NoSuchElementException::new)
                .getDrivers()
                .stream()
                .map(DriverViewModel::fromDriver)
                .toList();
    }

    public ConstructorViewModel getConstructorWithMostWins() {
        return this.constructorRepository
                .findConstructorWithMostWins()
                .stream()
                .map(ConstructorViewModel::fromConstructor)
                .toList().get(0);
    }

    public ConstructorViewModel getConstructorWithMostTitles() {
        return this.constructorRepository
                .findConstructorWithMostTitles()
                .stream()
                .map(ConstructorViewModel::fromConstructor)
                .toList().get(0);
    }

    public ConstructorViewModel getOldestConstructor() {
        return this.constructorRepository
                .findOldestTeam()
                .stream()
                .map(ConstructorViewModel::fromConstructor)
                .toList().get(0);
    }

    public ConstructorViewModel getYoungestConstructor() {
        return this.constructorRepository
                .findYoungestTeam()
                .stream()
                .map(ConstructorViewModel::fromConstructor)
                .toList().get(0);
    }

    public void addWinToConstructor(String driverName) {
        final String constructorName = this.driverService.getConstructorOfDriver(driverName);

        final ConstructorModel constructorWinner = this.modelMapper.map(
                this.constructorRepository.findByName(constructorName).orElseThrow(NoSuchElementException::new),
                ConstructorModel.class
        );

        constructorWinner.setNumberOfWins(constructorWinner.getNumberOfWins() + 1);

        this.constructorRepository.saveAndFlush(this.modelMapper.map(constructorWinner, Constructor.class));
    }
}
