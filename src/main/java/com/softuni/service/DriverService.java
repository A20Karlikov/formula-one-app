package com.softuni.service;

import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<DriverViewModel> getAllDrivers() {
        return this.driverRepository
                .findAll()
                .stream()
                .map(DriverViewModel::fromDriver)
                .toList();
    }
}
