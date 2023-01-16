package org.maxkizi.socialnetworkbackend.service;

import org.maxkizi.socialnetworkbackend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAll(Pageable pageable);
}
