package com.softuni.service;

import com.softuni.domain.dto.view.ConstructorViewModel;
import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.domain.entities.Driver;
import com.softuni.repository.ConstructorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class ConstructorService {

    private final ConstructorRepository constructorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ConstructorService(
            ConstructorRepository constructorRepository,
            ModelMapper modelMapper
            ) {
        this.constructorRepository = constructorRepository;
        this.modelMapper = modelMapper;
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
}
