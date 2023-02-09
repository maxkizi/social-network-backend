package org.maxkizi.socialnetworkbackend.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.maxkizi.socialnetworkbackend.BaseIntegrationTest;
import org.maxkizi.socialnetworkbackend.TestDataProvider;
import org.maxkizi.socialnetworkbackend.entity.User;
import org.maxkizi.socialnetworkbackend.exception.UserNotFoundException;
import org.maxkizi.socialnetworkbackend.repository.UserRepository;
import org.maxkizi.socialnetworkbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootTest
class UserServiceImplTest extends BaseIntegrationTest {
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final TestDataProvider testDataProvider;
    private final UserRepository repository;

    @Autowired
    public UserServiceImplTest(UserService userService, UserDetailsService userDetailsService, TestDataProvider testDataProvider, UserRepository repository) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.testDataProvider = testDataProvider;
        this.repository = repository;
    }

    @AfterEach
    void deleteAll() {
        repository.deleteAll();
    }

    @Test
    void saveAndFindAll() {
        userService.save(testDataProvider.buildUser(1));
        userService.save(testDataProvider.buildUser(2));

        Assertions.assertEquals(2, userService.findAll(Pageable.unpaged()).getTotalElements());
    }

    @Test
    void saveAndFind() {
        User userToSave = testDataProvider.buildUser(1);
        Long id = userService.save(userToSave).getId();

        Assertions.assertEquals(userToSave, userService.findById(id));
    }

    @Test
    void saveAndDelete() {
        User userToSave = testDataProvider.buildUser(1);
        Long id = userService.save(userToSave).getId();

        Assertions.assertDoesNotThrow(() -> userService.delete(id));
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.delete(id));
    }

    @Test
    void saveAndUpdate() {
        String username = "user name for update";
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.update(456789L, new User()));

        User userToSave = testDataProvider.buildUser(1);
        Long id = userService.save(userToSave).getId();

        userToSave.setUsername(username);
        User updatedUser = userService.update(id, userToSave);

        Assertions.assertEquals(updatedUser, userToSave);
    }

    @Test
    void saveAndLoadUserByUsername() {
        User userToSave = testDataProvider.buildUser(1);
        String username = userService.save(userToSave).getUsername();

        Assertions.assertEquals(userToSave, userDetailsService.loadUserByUsername(username));
    }
}