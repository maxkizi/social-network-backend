package org.maxkizi.socialnetworkbackend.controller;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetworkbackend.dto.ShortUserInfoDto;
import org.maxkizi.socialnetworkbackend.entity.User;
import org.maxkizi.socialnetworkbackend.mapper.UserDtoConverter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.maxkizi.socialnetworkbackend.controller.Controllers.ME;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserDtoConverter userDtoConverter;

    @GetMapping(ME)
    public ShortUserInfoDto me(Authentication authentication) {
        return userDtoConverter.toShortDto((User) authentication.getPrincipal());
    }
}
