package org.maxkizi.socialnetwork.base.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.maxkizi.socialnetwork.base.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetwork.base.dto.ShortUserInfoDto;
import org.maxkizi.socialnetwork.common.entity.User;


class UserDtoConverterTest {

    private final UserDtoConverter mapper = new UserDtoConverterImpl();

    @Test
    void toShortDtoTest() {
        User user = buildUser();
        ShortUserInfoDto shortDto = mapper.toShortDto(user);
        Assertions.assertEquals(shortDto.getId(), user.getId());
        Assertions.assertEquals(shortDto.getFirstName(), user.getFirstName());
        Assertions.assertEquals(shortDto.getLastName(), user.getLastName());
        Assertions.assertEquals(shortDto.getCountry(), user.getCountry());
        Assertions.assertEquals(shortDto.getUserPhotoUrl(), user.getUserPhotoUrl());

    }

    @Test
    void toProfileDtoTest() {
        User user = buildUser();
        ProfileUserInfoDto dto = mapper.toDto(user);
        Assertions.assertEquals(dto.getId(), user.getId());
        Assertions.assertEquals(dto.getFirstName(), user.getFirstName());
        Assertions.assertEquals(dto.getLastName(), user.getLastName());
        Assertions.assertEquals(dto.getCountry(), user.getCountry());
        Assertions.assertEquals(dto.getUserPhotoUrl(), user.getUserPhotoUrl());
        Assertions.assertEquals(dto.getStatus(), user.getStatus());
        Assertions.assertEquals(dto.getInfo(), user.getInfo());
    }

    private User buildUser() {
        return User.builder()
                .id(1L)
                .userPhotoUrl("url")
                .info("about me")
                .country("country")
                .firstName("maxim")
                .lastName("kizilov")
                .build();
    }

}