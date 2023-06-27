package org.maxkizi.socialnetwork.base.controller;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetwork.base.service.FollowerService;
import org.maxkizi.socialnetwork.common.entity.BaseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FollowingController {
    private final FollowerService service;

    @PostMapping(Controllers.FOLLOW)
    public void follow(@PathVariable(name = "id") Long userId, Authentication authentication) {
        BaseEntity principal = (BaseEntity) authentication.getPrincipal();
        service.follow(principal.getId(), userId);
    }

    @DeleteMapping(Controllers.FOLLOW)
    public void unfollow(@PathVariable(name = "id") Long userId, Authentication authentication) {
        BaseEntity principal = (BaseEntity) authentication.getPrincipal();
        service.unfollow(principal.getId(), userId);
    }

    @GetMapping(Controllers.FOLLOW)
    public boolean isFollow(@PathVariable(name = "id") Long userId, Authentication authentication) {
        BaseEntity principal = (BaseEntity) authentication.getPrincipal();
        return service.isFollow(principal.getId(), userId);
    }
}
