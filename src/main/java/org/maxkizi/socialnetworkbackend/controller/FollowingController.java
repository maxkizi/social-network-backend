package org.maxkizi.socialnetworkbackend.controller;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetworkbackend.entity.BaseEntity;
import org.maxkizi.socialnetworkbackend.service.FollowerService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static org.maxkizi.socialnetworkbackend.controller.Controllers.FOLLOW;

@RestController
@RequiredArgsConstructor
public class FollowingController {
    private final FollowerService service;

    @PostMapping(FOLLOW)
    public void follow(@PathVariable(name = "id") Long userId, Authentication authentication) {
        BaseEntity principal = (BaseEntity) authentication.getPrincipal();
        service.follow(principal.getId(), userId);
    }

    @DeleteMapping(FOLLOW)
    public void unfollow(@PathVariable(name = "id") Long userId, Authentication authentication) {
        BaseEntity principal = (BaseEntity) authentication.getPrincipal();
        service.unfollow(principal.getId(), userId);
    }

    @GetMapping(FOLLOW)
    public boolean isFollow(@PathVariable(name = "id") Long userId, Authentication authentication) {
        BaseEntity principal = (BaseEntity) authentication.getPrincipal();
        return service.isFollow(principal.getId(), userId);
    }
}
