package org.maxkizi.socialnetwork.base.controller;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetwork.base.dto.AuthenticatedUserDto;
import org.maxkizi.socialnetwork.base.mapper.UserDtoConverter;
import org.maxkizi.socialnetwork.common.entity.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserDtoConverter userDtoConverter;

    @GetMapping(Controllers.ME)
    public AuthenticatedUserDto me(Authentication authentication) {
        return userDtoConverter.toAuthenticatedUserDto((UserDetailsImpl) authentication.getPrincipal());
    }
}
