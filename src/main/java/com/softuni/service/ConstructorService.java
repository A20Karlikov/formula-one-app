package com.softuni.service;

import com.softuni.domain.dto.view.ConstructorViewModel;
import com.softuni.repository.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.List;

@Service
public class ConstructorService {

    private final ConstructorRepository constructorRepository;

    @Autowired
    public ConstructorService(ConstructorRepository constructorRepository) {
        this.constructorRepository = constructorRepository;
    }

    public List<ConstructorViewModel> getAllConstructors() {
        return this.constructorRepository
                .findAll()
                .stream()
                .map(ConstructorViewModel::fromConstructor)
                .toList();
    }
}
