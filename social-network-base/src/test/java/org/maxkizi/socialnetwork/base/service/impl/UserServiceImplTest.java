package org.maxkizi.socialnetwork.base.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.maxkizi.socialnetwork.base.BaseIntegrationTest;
import org.maxkizi.socialnetwork.base.TestDataProvider;
import org.maxkizi.socialnetwork.base.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetwork.base.exception.UserNotFoundException;
import org.maxkizi.socialnetwork.base.service.UserService;
import org.maxkizi.socialnetwork.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

class UserServiceImplTest extends BaseIntegrationTest {
    private final UserService userService;
    private final TestDataProvider testDataProvider;
    private final UserRepository repository;

    @Autowired
    public UserServiceImplTest(UserService userService, TestDataProvider testDataProvider, UserRepository repository) {
        this.userService = userService;
        this.testDataProvider = testDataProvider;
        this.repository = repository;
    }

    @AfterEach
    void deleteAll() {
        repository.deleteAll();
    }

    @Test
    void saveAndFindAll() {
        ProfileUserInfoDto savedUser = userService.save(testDataProvider.buildUserProfileDto(1));
        userService.save(testDataProvider.buildUserProfileDto(2));

        Assertions.assertEquals(2, userService.findAll(Pageable.unpaged(), savedUser.getId()).getTotalElements());
    }

    @Test
    void saveAndFind() {
        ProfileUserInfoDto userToSave = testDataProvider.buildUserProfileDto(1);
        Long id = userService.save(userToSave).getId();

        ProfileUserInfoDto foundUser = userService.findById(id);
        setGeneratedFields(foundUser, userToSave);
        Assertions.assertEquals(userToSave, foundUser);
    }

    @Test
    void saveAndDelete() {
        ProfileUserInfoDto userToSave = testDataProvider.buildUserProfileDto(1);
        Long id = userService.save(userToSave).getId();

        Assertions.assertDoesNotThrow(() -> userService.delete(id));
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.delete(id));
    }

    @Test
    void saveAndUpdate() {
        String country = "country name for update";
        Assertions.assertThrows(UserNotFoundException.class, () -> userService.update(456789L, new ProfileUserInfoDto()));

        ProfileUserInfoDto userToSave = testDataProvider.buildUserProfileDto(1);
        Long id = userService.save(userToSave).getId();

        userToSave.setCountry(country);
        ProfileUserInfoDto updatedUser = userService.update(id, userToSave);

        setGeneratedFields(updatedUser, userToSave);

        Assertions.assertEquals(userToSave, updatedUser);
    }

    private void setGeneratedFields(ProfileUserInfoDto withGenerated, ProfileUserInfoDto target) {
        target.setCreatedAt(withGenerated.getCreatedAt());
        target.setUpdatedAt(withGenerated.getUpdatedAt());
        target.setId(withGenerated.getId());
    }
}