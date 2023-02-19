package org.maxkizi.socialnetworkbackend.controller;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetworkbackend.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetworkbackend.dto.ShortUserInfoDto;
import org.maxkizi.socialnetworkbackend.entity.BaseEntity;
import org.maxkizi.socialnetworkbackend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.maxkizi.socialnetworkbackend.controller.Controllers.PROFILE_BY_ID;
import static org.maxkizi.socialnetworkbackend.controller.Controllers.USERS;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(USERS)
    public Page<ShortUserInfoDto> findAll(Pageable pageable, Authentication authentication) {
        BaseEntity principal = (BaseEntity) authentication.getPrincipal();
        return userService.findAll(pageable, principal.getId());
    }

    @GetMapping(PROFILE_BY_ID)
    public ProfileUserInfoDto findById(@PathVariable(name = "id") Long id) {
        return userService.findById(id);
    }
}
