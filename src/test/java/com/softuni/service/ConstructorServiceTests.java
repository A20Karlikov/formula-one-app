package com.softuni.service;

import com.softuni.domain.dto.models.ConstructorModel;
import com.softuni.domain.dto.view.ConstructorViewModel;
import com.softuni.domain.dto.view.DriverViewModel;
import com.softuni.domain.entities.Constructor;
import com.softuni.domain.entities.Driver;
import com.softuni.domain.enums.DriverLevel;
import com.softuni.domain.enums.PowerUnitName;
import com.softuni.repository.ConstructorRepository;
import com.softuni.repository.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ConstructorServiceTests {

    @InjectMocks
    private ConstructorService constructorService;

    @Mock
    private DriverService driverService;

    @Mock
    private ConstructorRepository constructorRepository;

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private ModelMapper modelMapper;

    private Constructor constructorRedBull;
    private Constructor constructorFerrari;
    List<Constructor> constructors = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        constructorRedBull = new Constructor() {{
            setId(1L);
            setName("RedBull");
            setEngine(PowerUnitName.HONDA);
            setCarImageUrl("carImageUrl");
            setFirstTeamEntry(1990);
            setWorldTitles(6);
            setNumberOfWins(120);
        }};

        constructorFerrari = new Constructor() {{
            setId(2L);
            setName("Ferrari");
            setEngine(PowerUnitName.FERRARI);
            setCarImageUrl("carImageUrl2");
            setFirstTeamEntry(1950);
            setWorldTitles(16);
            setNumberOfWins(320);
        }};

        constructors.add(constructorRedBull);
        constructors.add(constructorFerrari);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void constructorService_GetAllConstructorsTest() {
        // Arrange
        when(constructorRepository.findAll()).thenReturn(constructors);

        // Act
        List<ConstructorViewModel> result = constructorService.getAllConstructors();

        // Assert
        assertNotNull(result);
        assertEquals(constructors.size(), result.size());

        assertEquals(result.get(0).getName(), constructors.get(0).getName());
        assertEquals(result.get(0).getEngine(), constructors.get(0).getEngine());
        assertEquals(result.get(0).getCarImageUrl(), constructors.get(0).getCarImageUrl());
        assertEquals(result.get(0).getNumberOfWins(), constructors.get(0).getNumberOfWins());

        assertEquals(result.get(1).getName(), constructors.get(1).getName());
        assertEquals(result.get(1).getEngine(), constructors.get(1).getEngine());
        assertEquals(result.get(1).getCarImageUrl(), constructors.get(1).getCarImageUrl());
        assertEquals(result.get(1).getNumberOfWins(), constructors.get(1).getNumberOfWins());
    }

    @Test
    public void constructorService_GetConstructorByNameTest() {
        // Arrange
        ConstructorViewModel constructorViewModel = ConstructorViewModel.fromConstructor(constructorFerrari);

        when(constructorRepository.findByName(constructorFerrari.getName())).thenReturn(Optional.of(constructorFerrari));
        when(modelMapper.map(Optional.of(constructorFerrari), ConstructorViewModel.class)).thenReturn(constructorViewModel);

        // Act
        ConstructorViewModel result = constructorService.getConstructorByName(constructorFerrari.getName());

        // Assert
        assertNotNull(result);
        assertEquals(result.getName(), constructorFerrari.getName());
        assertEquals(result.getEngine(), constructorFerrari.getEngine());
        assertEquals(result.getNumberOfWins(), constructorFerrari.getNumberOfWins());
    }

    @Test
    public void constructorService_GetTeamDriversTest() {
        // Arrange
        Driver driverMax = new Driver() {{
            setId(1L);
            setConstructor(constructorRedBull);
            setName("Max");
            setCountry("Holland");
            setDescription("description");
            setImageUrl("imageUrl");
            setLevel(DriverLevel.EPIC);
            setNumberOfWins(50);
            setPodiums(90);
            setRaceNumber(1);
        }};

        Driver driverCheco = new Driver() {{
            setId(2L);
            setConstructor(constructorRedBull);
            setName("Checo");
            setCountry("Mexico");
            setDescription("description2");
            setImageUrl("imageUrl2");
            setLevel(DriverLevel.ADVANCED);
            setNumberOfWins(10);
            setPodiums(50);
            setRaceNumber(11);
        }};

        Set<Driver> driverList = Set.of(driverMax, driverCheco);
        constructorRedBull.setDrivers(driverList);
        DriverViewModel driverViewModelMax = DriverViewModel.fromDriver(driverMax);
        DriverViewModel driverViewModelCheco = DriverViewModel.fromDriver(driverCheco);
        List<DriverViewModel> expectedDrivers = List.of(driverViewModelMax, driverViewModelCheco);

        when(constructorRepository.findByName(constructorRedBull.getName())).thenReturn(Optional.of(constructorRedBull));

        // Act
        List<DriverViewModel> result = constructorService.getTeamDrivers(constructorRedBull.getName());

        // Assert
        assertEquals(expectedDrivers.size(), result.size());
        assertEquals(expectedDrivers.get(0), result.get(0));
        assertEquals(expectedDrivers.get(1), result.get(1));
    }

    @Test
    public void constructorService_GetConstructorWithMostWinsTest() {
        // Arrange
        ConstructorViewModel expectedConstructor = ConstructorViewModel.fromConstructor(constructorFerrari);
        List<Constructor> constructorsWithMostWins = new ArrayList<>();
        constructorsWithMostWins.add(constructorFerrari);
        constructorsWithMostWins.add(constructorRedBull);

        when(constructorRepository.findConstructorWithMostWins()).thenReturn(constructorsWithMostWins);

        // Act
        ConstructorViewModel result = constructorService.getConstructorWithMostWins();

        // Assert
        assertNotNull(result);
        assertEquals(expectedConstructor.getName(), result.getName());
        assertEquals(expectedConstructor.getNumberOfWins(), result.getNumberOfWins());
    }

    @Test
    public void constructorService_GetConstructorWithMostTitlesTest() {
        // Arrange
        ConstructorViewModel expectedConstructor = ConstructorViewModel.fromConstructor(constructorRedBull);
        List<Constructor> constructorsWithMostTitles = new ArrayList<>();
        constructorsWithMostTitles.add(constructorRedBull);
        constructorsWithMostTitles.add(constructorFerrari);

        when(constructorRepository.findConstructorWithMostTitles()).thenReturn(constructorsWithMostTitles);

        // Act
        ConstructorViewModel result = constructorService.getConstructorWithMostTitles();

        // Assert
        assertNotNull(result);
        assertEquals(expectedConstructor.getName(), result.getName());
        assertEquals(expectedConstructor.getWorldTitles(), result.getWorldTitles());
    }

    @Test
    public void constructorService_GetOldestConstructorTest() {
        // Arrange
        ConstructorViewModel expectedConstructor = ConstructorViewModel.fromConstructor(constructorRedBull);
        List<Constructor> oldestConstructors = new ArrayList<>();
        oldestConstructors.add(constructorRedBull);
        oldestConstructors.add(constructorFerrari);

        when(constructorRepository.findOldestTeam()).thenReturn(oldestConstructors);

        // Act
        ConstructorViewModel result = constructorService.getOldestConstructor();

        // Assert
        assertNotNull(result);
        assertEquals(expectedConstructor.getName(), result.getName());
        assertEquals(expectedConstructor.getFirstTeamEntry(), result.getFirstTeamEntry());
    }

    @Test
    public void constructorService_GetYoungestConstructorTest() {
        // Arrange
        ConstructorViewModel expectedConstructor = ConstructorViewModel.fromConstructor(constructorFerrari);
        List<Constructor> youngestConstructors = new ArrayList<>();
        youngestConstructors.add(constructorFerrari);
        youngestConstructors.add(constructorRedBull);

        when(constructorRepository.findYoungestTeam()).thenReturn(youngestConstructors);

        // Act
        ConstructorViewModel result = constructorService.getYoungestConstructor();

        // Assert
        assertNotNull(result);
        assertEquals(expectedConstructor.getName(), result.getName());
        assertEquals(expectedConstructor.getFirstTeamEntry(), result.getFirstTeamEntry());
    }

    @Test
    public void constructorService_AddWinToConstructorTest() {
        // Arrange
        String driverName = "Charles";
        ConstructorModel constructorModel = new ConstructorModel();
        constructorModel.setNumberOfWins(constructorFerrari.getNumberOfWins());

        when(driverService.getConstructorNameOfDriver(driverName)).thenReturn(constructorFerrari.getName());
        when(constructorRepository.findByName(constructorFerrari.getName())).thenReturn(Optional.of(constructorFerrari));
        when(modelMapper.map(constructorFerrari, ConstructorModel.class)).thenReturn(constructorModel);
        when(modelMapper.map(constructorModel, Constructor.class)).thenReturn(constructorFerrari);

        // Act
        constructorService.addWinToConstructor(driverName);

        // Assert
        assertEquals(constructorFerrari.getNumberOfWins() + 1, constructorModel.getNumberOfWins());
        verify(constructorRepository).saveAndFlush(constructorFerrari);
    }
}
