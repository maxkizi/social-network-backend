package org.maxkizi.socialnetwork.base.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.maxkizi.socialnetwork.base.dto.AuthenticatedUserDto;
import org.maxkizi.socialnetwork.base.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetwork.base.dto.ShortUserInfoDto;
import org.maxkizi.socialnetwork.common.entity.User;
import org.maxkizi.socialnetwork.common.entity.UserDetailsImpl;

@Mapper(builder = @Builder(disableBuilder = true))
public abstract class UserDtoConverter {

    public abstract ProfileUserInfoDto toDto(User user);

    public abstract ShortUserInfoDto toShortDto(User user);

    public abstract AuthenticatedUserDto toAuthenticatedUserDto(UserDetailsImpl userDetails);

    public abstract User toEntity(ProfileUserInfoDto user);

    @AfterMapping
    public void setUserToEachPost(@MappingTarget final User user) {
        user.getPosts().forEach(post -> post.setUser(user));
    }
}