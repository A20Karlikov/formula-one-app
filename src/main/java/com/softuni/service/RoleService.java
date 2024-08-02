package com.softuni.service;

import com.softuni.domain.dto.models.RoleModel;
import com.softuni.domain.enums.RoleName;
import com.softuni.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    public Set<RoleModel> findAllRoles() {
        return this.roleRepository
                .findAll()
                .stream()
                .map(role -> this.modelMapper.map(role, RoleModel.class))
                .collect(Collectors.toSet());
    }

    public RoleModel findRoleByName(String name) {
        return this.modelMapper
                .map(this.roleRepository.findByRole(RoleName.valueOf(name))
                                .orElseThrow(NoSuchElementException::new),
                        RoleModel.class);
    }
}
