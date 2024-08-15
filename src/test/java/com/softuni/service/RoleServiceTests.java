package com.softuni.service;

import com.softuni.domain.dto.models.RoleModel;
import com.softuni.domain.entities.Role;
import com.softuni.domain.enums.RoleName;
import com.softuni.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RoleServiceTests {

    @InjectMocks
    private RoleService roleService;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private ModelMapper modelMapper;

    private Role roleUser;
    private Role roleAdmin;

    @BeforeEach
    public void setUp() {
        roleUser = new Role() {{
            setId(1L);
            setRole(RoleName.USER);
        }};

        roleAdmin = new Role() {{
            setId(2L);
            setRole(RoleName.ADMIN);
        }};

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void roleService_FindAllRolesTest() {
        // Arrange
        RoleModel roleModelUser = new RoleModel() {{
            setId(roleUser.getId());
            setRole(RoleName.USER);
        }};

        RoleModel roleModelAdmin = new RoleModel() {{
            setId(roleAdmin.getId());
            setRole(RoleName.ADMIN);
        }};
        Set<RoleModel> roleModels = Set.of(roleModelAdmin, roleModelUser);

        when(roleRepository.findAll()).thenReturn(List.of(roleAdmin, roleUser));
        when(modelMapper.map(roleUser, RoleModel.class)).thenReturn(roleModelUser);
        when(modelMapper.map(roleAdmin, RoleModel.class)).thenReturn(roleModelAdmin);

        // Act
        Set<RoleModel> result = roleService.findAllRoles();

        // Assert
        assertNotNull(result);
        assertEquals(roleModels.size(), result.size());
        assertThat(result).containsOnly(roleModelUser, roleModelAdmin);
    }

    @Test
    public void roleService_FindRoleByNameTest() {
        // Arrange
        RoleModel roleModelUser = new RoleModel() {{
            setId(roleUser.getId());
            setRole(RoleName.USER);
        }};

        when(roleRepository.findByRole(RoleName.valueOf(roleModelUser.getRole().name()))).thenReturn(Optional.of(roleUser));
        when(modelMapper.map(roleUser, RoleModel.class)).thenReturn(roleModelUser);

        // Act
        RoleModel result = roleService.findRoleByName(RoleName.USER.name());

        // Assert
        assertThat(result).isEqualTo(roleModelUser);
    }
}
