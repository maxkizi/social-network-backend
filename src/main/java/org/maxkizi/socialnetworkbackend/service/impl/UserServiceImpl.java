package org.maxkizi.socialnetworkbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetworkbackend.entity.User;
import org.maxkizi.socialnetworkbackend.repository.UserRepository;
import org.maxkizi.socialnetworkbackend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
