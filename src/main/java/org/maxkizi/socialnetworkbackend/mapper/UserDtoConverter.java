package org.maxkizi.socialnetworkbackend.mapper;

import org.mapstruct.Mapper;
import org.maxkizi.socialnetworkbackend.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetworkbackend.dto.ShortUserInfoDto;
import org.maxkizi.socialnetworkbackend.entity.User;

@Mapper
public interface UserDtoConverter {

    ProfileUserInfoDto toDto(User user);

    ShortUserInfoDto toShortDto(User user);
}