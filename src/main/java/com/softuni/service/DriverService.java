package com.softuni.service;

import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.repository.DriverRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
