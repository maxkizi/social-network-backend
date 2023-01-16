package org.maxkizi.socialnetworkbackend.service.impl;

import org.junit.jupiter.api.Test;
import org.maxkizi.socialnetworkbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {

    private UserService userService;

    @Autowired
    UserServiceImplTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    void findAll() {
//        System.out.println(userService.findAll());
    }
}