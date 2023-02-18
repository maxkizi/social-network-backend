package org.maxkizi.socialnetworkbackend;

import org.maxkizi.socialnetworkbackend.dto.ProfileUserInfoDto;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class TestDataProvider {
    public ProfileUserInfoDto buildUserProfileDto(int i) {
        return ProfileUserInfoDto.builder()
                .info("info" + i)
                .userPhotoUrl("url" + i)
                .lastName("lastname" + i)
                .firstName("firstname" + i)
                .country("country" + i)
                .status("status" + i)
                .posts(Collections.emptyList())
                .build();
    }
}
