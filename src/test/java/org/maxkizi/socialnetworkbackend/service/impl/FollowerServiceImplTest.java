package org.maxkizi.socialnetworkbackend.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.maxkizi.socialnetworkbackend.BaseIntegrationTest;
import org.maxkizi.socialnetworkbackend.TestDataProvider;
import org.maxkizi.socialnetworkbackend.dto.ShortUserInfoDto;
import org.maxkizi.socialnetworkbackend.entity.User;
import org.maxkizi.socialnetworkbackend.exception.UserAlreadyFollowerException;
import org.maxkizi.socialnetworkbackend.repository.UserRepository;
import org.maxkizi.socialnetworkbackend.service.FollowerService;
import org.maxkizi.socialnetworkbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

class FollowerServiceImplTest extends BaseIntegrationTest {

    private final FollowerService followerService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final TestDataProvider testDataProvider;
    private User user1;
    private User user2;

    @Autowired
    FollowerServiceImplTest(FollowerService followerService, UserService userService, UserRepository userRepository, TestDataProvider testDataProvider) {
        this.followerService = followerService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.testDataProvider = testDataProvider;
    }

    @BeforeEach
    void createTestUsers() {
        user1 = testDataProvider.buildUser(1);
        user2 = testDataProvider.buildUser(2);

        userRepository.saveAll(List.of(user1, user2));
    }

    @AfterEach
    void deleteAll() {
        userRepository.deleteAll();
    }

    @Test
    void testFollowAndUnfollow() {
        List<ShortUserInfoDto> followersList = userService.findAll(Pageable.unpaged(), user1.getId())
                .stream().filter(ShortUserInfoDto::isFollower).collect(Collectors.toList());
        Assertions.assertTrue(followersList.isEmpty());

        followerService.follow(user1.getId(), user2.getId());
        followersList = userService.findAll(Pageable.unpaged(), user1.getId())
                .stream().filter(ShortUserInfoDto::isFollower).collect(Collectors.toList());
        Assertions.assertEquals(1, followersList.size());
        Assertions.assertTrue(followerService.isFollow(user1.getId(), user2.getId()));

        followerService.unfollow(user1.getId(), user2.getId());
        followersList = userService.findAll(Pageable.unpaged(), user1.getId())
                .stream().filter(ShortUserInfoDto::isFollower).collect(Collectors.toList());
        Assertions.assertTrue(followersList.isEmpty());
        Assertions.assertFalse(followerService.isFollow(user1.getId(), user2.getId()));
    }

    @Test
    void testFollowsOnFollower_shouldThrowsSqlException() {
        followerService.follow(user1.getId(), user2.getId());
        Assertions.assertThrows(UserAlreadyFollowerException.class, () -> followerService.follow(user1.getId(), user2.getId()));
    }

}