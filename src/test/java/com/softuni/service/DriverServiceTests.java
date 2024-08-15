package com.softuni.service;

import com.softuni.domain.dto.models.ConstructorModel;
import com.softuni.domain.dto.models.DriverModel;
import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.domain.entities.Constructor;
import com.softuni.domain.entities.Driver;
import com.softuni.domain.enums.DriverLevel;
import com.softuni.repository.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DriverServiceTests {

    @InjectMocks
    private DriverService driverService;

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private ModelMapper modelMapper;

    private Driver driverMax;
    private Driver driverCharles;
    List<Driver> drivers = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        driverMax = new Driver() {{
            setId(1L);
            setConstructor(mock(Constructor.class));
            setName("Max");
            setCountry("Holland");
            setDescription("description");
            setImageUrl("imageUrl");
            setLevel(DriverLevel.EPIC);
            setNumberOfWins(50);
            setPodiums(90);
            setRaceNumber(1);
        }};

        driverCharles = new Driver() {{
            setId(2L);
            setConstructor(mock(Constructor.class));
            setName("Charles");
            setCountry("Monaco");
            setDescription("description2");
            setImageUrl("imageUrl2");
            setLevel(DriverLevel.ADVANCED);
            setNumberOfWins(100);
            setPodiums(40);
            setRaceNumber(16);
        }};

        drivers.add(driverMax);
        drivers.add(driverCharles);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void driverService_GetAllDriversTest() {
        // Arrange
        when(driverRepository.findAll()).thenReturn(drivers);

        // Act
        List<DriverViewModel> result = driverService.getAllDrivers();

        // Assert
        assertNotNull(result);
        assertEquals(drivers.size(), result.size());

        assertEquals(result.get(0).getName(), drivers.get(0).getName());
        assertEquals(result.get(0).getCountry(), drivers.get(0).getCountry());
        assertEquals(result.get(0).getConstructorName(), drivers.get(0).getConstructor().getName());
        assertEquals(result.get(0).getLevel(), drivers.get(0).getLevel());

        assertEquals(result.get(1).getName(), drivers.get(1).getName());
        assertEquals(result.get(1).getCountry(), drivers.get(1).getCountry());
        assertEquals(result.get(1).getConstructorName(), drivers.get(1).getConstructor().getName());
        assertEquals(result.get(1).getLevel(), drivers.get(1).getLevel());
    }

    @Test
    public void driverService_GetDriverDetailsTest() {
        // Arrange
        DriverViewModel driverViewModel = DriverViewModel.fromDriver(driverMax);

        when(driverRepository.findByName(driverMax.getName())).thenReturn(Optional.of(driverMax));
        when(modelMapper.map(Optional.of(driverMax), DriverViewModel.class)).thenReturn(driverViewModel);

        // Act
        DriverViewModel result = driverService.getDriverDetails(driverMax.getName());

        // Assert
        assertNotNull(result);
        assertEquals(driverMax.getName(), result.getName());
        assertEquals(driverMax.getPodiums(), result.getPodiums());
        assertEquals(driverMax.getConstructor().getName(), result.getConstructorName());
        assertEquals(driverMax.getLevel(), result.getLevel());
        assertEquals(driverMax.getImageUrl(), result.getImageUrl());
    }

    @Test
    public void driverService_GetDriverWithMostWinsTest() {
        // Arrange
        DriverViewModel expectedDriver = DriverViewModel.fromDriver(driverCharles);
        List<Driver> driversWithMostWins = new ArrayList<>();
        driversWithMostWins.add(driverCharles);
        driversWithMostWins.add(driverMax);

        when(driverRepository.findDriverWithMostWins()).thenReturn(driversWithMostWins);

        // Act
        DriverViewModel result = driverService.getDriverWithMostWins();

        // Assert
        assertNotNull(result);
        assertEquals(expectedDriver.getName(), result.getName());
        assertEquals(expectedDriver.getNumberOfWins(), result.getNumberOfWins());
    }

    @Test
    public void driverService_GetDriverWithMostPodiumsTest() {
        // Arrange
        DriverViewModel expectedDriver = DriverViewModel.fromDriver(driverMax);
        List<Driver> driversWithMostPodiums = new ArrayList<>();
        driversWithMostPodiums.add(driverMax);
        driversWithMostPodiums.add(driverCharles);

        when(driverRepository.findDriverWithMostPodiums()).thenReturn(driversWithMostPodiums);

        // Act
        DriverViewModel result = driverService.getDriverWithMostPodiums();

        // Assert
        assertNotNull(result);
        assertEquals(expectedDriver.getName(), result.getName());
        assertEquals(expectedDriver.getPodiums(), result.getPodiums());
    }

    @Test
    public void driverService_GetCountryWithMostDriversTest() {
        // Arrange
        String expectedCountry = "Monaco";
        List<String> countriesWithMostDrivers = new ArrayList<>();
        countriesWithMostDrivers.add(driverCharles.getCountry());
        countriesWithMostDrivers.add(driverMax.getCountry());

        when(driverRepository.findCountryWithMostDrivers()).thenReturn(countriesWithMostDrivers);

        // Act
        String result = driverService.getCountryWithMostDrivers();

        // Assert
        assertNotNull(result);
        assertEquals(expectedCountry, result);
    }

    @Test
    public void driverService_GetDriversNames() {
        // Arrange
        List<String> expectedDrivers = new ArrayList<>();
        expectedDrivers.add("Max");
        expectedDrivers.add("Charles");

        when(driverRepository.findAll()).thenReturn(drivers);

        // Act
        List<String> result = driverService.getDriversNames();

        // Assert
        assertNotNull(result);
        assertEquals(expectedDrivers.get(0), result.get(0));
        assertEquals(expectedDrivers.get(1), result.get(1));
    }

    @Test
    public void driverService_AddWinAndPodiumToDriver_IsWinnerTest() {
        // Arrange
        DriverModel driverModel = new DriverModel();
        driverModel.setNumberOfWins(driverMax.getNumberOfWins());
        driverModel.setPodiums(driverMax.getPodiums());

        when(driverRepository.findByName(driverMax.getName())).thenReturn(Optional.of(driverMax));
        when(modelMapper.map(driverMax, DriverModel.class)).thenReturn(driverModel);
        when(modelMapper.map(driverModel, Driver.class)).thenReturn(driverMax);

        // Act
        driverService.addWinAndPodiumToDriver(driverMax.getName(), true);

        // Assert
        assertEquals(driverMax.getNumberOfWins() + 1, driverModel.getNumberOfWins());
        assertEquals(driverMax.getPodiums() + 1, driverModel.getPodiums());
        verify(driverRepository).saveAndFlush(driverMax);
    }

    @Test
    public void driverService_AddWinAndPodiumToDriver_IsNotWinnerTest() {
        // Arrange
        DriverModel driverModel = new DriverModel();
        driverModel.setNumberOfWins(driverMax.getNumberOfWins());
        driverModel.setPodiums(driverMax.getPodiums());

        when(driverRepository.findByName(driverMax.getName())).thenReturn(Optional.of(driverMax));
        when(modelMapper.map(driverMax, DriverModel.class)).thenReturn(driverModel);
        when(modelMapper.map(driverModel, Driver.class)).thenReturn(driverMax);

        // Act
        driverService.addWinAndPodiumToDriver(driverMax.getName(), false);

        // Assert
        assertEquals(driverMax.getNumberOfWins(), driverModel.getNumberOfWins());
        assertEquals(driverMax.getPodiums() + 1, driverModel.getPodiums());
        verify(driverRepository).saveAndFlush(driverMax);
    }

    @Test
    public void driverService_getConstructorNameOfDriverTest() {
        // Arrange
        DriverModel driverModel = new DriverModel();
        driverModel.setConstructor(Mockito.mock(ConstructorModel.class));
        String expectedName = driverModel.getConstructor().getName();

        when(driverRepository.findByName(driverMax.getName())).thenReturn(Optional.of(driverMax));
        when(modelMapper.map(driverMax, DriverModel.class)).thenReturn(driverModel);

        // Act
        String result = driverService.getConstructorNameOfDriver(driverMax.getName());

        // Assert
        assertEquals(expectedName, result);
    }

}
