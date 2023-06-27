package org.maxkizi.socialnetwork.base.controller;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetwork.base.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetwork.base.dto.ShortUserInfoDto;
import org.maxkizi.socialnetwork.base.service.UserService;
import org.maxkizi.socialnetwork.common.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(Controllers.USERS)
    public Page<ShortUserInfoDto> findAll(Pageable pageable, Authentication authentication) {
        BaseEntity principal = (BaseEntity) authentication.getPrincipal();
        return userService.findAll(pageable, principal.getId());
    }

    @GetMapping(Controllers.PROFILE_BY_ID)
    public ProfileUserInfoDto findById(@PathVariable(name = "id") Long id) {
        return userService.findById(id);
    }

    @PutMapping(Controllers.PROFILE)
    public ProfileUserInfoDto update(@RequestBody ProfileUserInfoDto profileDto,
                                     Authentication authentication) {
        BaseEntity principal = (BaseEntity) authentication.getPrincipal();
        return userService.update(principal.getId(), profileDto);
    }
}
