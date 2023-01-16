package org.maxkizi.socialnetworkbackend.controller;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetworkbackend.entity.User;
import org.maxkizi.socialnetworkbackend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.maxkizi.socialnetworkbackend.controller.Controllers.USERS;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(USERS)
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(userService.findAll(pageable));
    }
}
