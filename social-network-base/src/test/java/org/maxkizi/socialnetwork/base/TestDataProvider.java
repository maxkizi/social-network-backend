package org.maxkizi.socialnetwork.base;

import org.maxkizi.socialnetwork.base.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetwork.common.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class TestDataProvider {
    private static final String INFO = "info";
    private static final String USER_PHOTO_URL = "url";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String COUNTRY = "country";
    private static final String STATUS = "status";


    public ProfileUserInfoDto buildUserProfileDto(int i) {
        return ProfileUserInfoDto.builder()
                .info(INFO + i)
                .userPhotoUrl(USER_PHOTO_URL + i)
                .lastName(FIRST_NAME + i)
                .firstName(LAST_NAME + i)
                .country(COUNTRY + i)
                .status(STATUS + i)
                .posts(Collections.emptyList())
                .build();
    }

    public User buildUser(int i) {
        return User.builder()
                .info(INFO + i)
                .userPhotoUrl(USER_PHOTO_URL + i)
                .lastName(LAST_NAME + i)
                .firstName(FIRST_NAME + i)
                .country(COUNTRY + i)
                .status(STATUS + i)
                .followers(Collections.emptySet())
                .build();
    }
}
