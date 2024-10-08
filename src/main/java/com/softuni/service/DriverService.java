package com.softuni.service;

import com.softuni.domain.dto.models.DriverModel;
import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.domain.entities.Driver;
import com.softuni.repository.DriverRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DriverService(
            DriverRepository driverRepository,
            ModelMapper modelMapper
            ) {
        this.driverRepository = driverRepository;
        this.modelMapper = modelMapper;
    }

    public List<DriverViewModel> getAllDrivers() {
        return this.driverRepository
                .findAll()
                .stream()
                .map(DriverViewModel::fromDriver)
                .toList();
    }

    public DriverViewModel getDriverDetails(String name) {
        return this.modelMapper.map(
                this.driverRepository.findByName(name),
                DriverViewModel.class
        );
    }

    public DriverViewModel getDriverWithMostWins() {
        return this.driverRepository
                .findDriverWithMostWins()
                .stream()
                .map(DriverViewModel::fromDriver)
                .toList().get(0);
    }

    public DriverViewModel getDriverWithMostPodiums() {
        return this.driverRepository
                .findDriverWithMostPodiums()
                .stream()
                .map(DriverViewModel::fromDriver)
                .toList().get(0);
    }

    public String getCountryWithMostDrivers() {
        return this.driverRepository.findCountryWithMostDrivers().get(0);
    }

    public List<String> getDriversNames() {
        return this.driverRepository.findAll().stream().map(Driver::getName).toList();
    }

    public void addWinAndPodiumToDriver(String name, Boolean isWinner) {
        final DriverModel winner = this.modelMapper.map(this.driverRepository.findByName(name).orElseThrow(NoSuchElementException::new), DriverModel.class);
        if (isWinner) {
            winner.setNumberOfWins(winner.getNumberOfWins() + 1);
        }
        winner.setPodiums(winner.getPodiums() + 1);

        this.driverRepository.saveAndFlush(this.modelMapper.map(winner, Driver.class));
    }

    public String getConstructorNameOfDriver(String driverName) {
        final DriverModel driver = this.modelMapper.map(this.driverRepository.findByName(driverName).orElseThrow(NoSuchElementException::new), DriverModel.class);

        return driver.getConstructor().getName();
    }
}
