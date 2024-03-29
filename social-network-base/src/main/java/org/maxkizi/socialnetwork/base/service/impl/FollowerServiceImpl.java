package org.maxkizi.socialnetwork.base.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.maxkizi.socialnetwork.base.exception.UserAlreadyFollowerException;
import org.maxkizi.socialnetwork.base.service.FollowerService;
import org.maxkizi.socialnetwork.common.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FollowerServiceImpl implements FollowerService {

    private final UserRepository userRepository;


    @Override
    @Transactional
    public void follow(Long principalId, Long userId) {
        try {
            userRepository.follow(principalId, userId);
        } catch (DataIntegrityViolationException e) {
            log.error("User (id={}) already follows user (id={})", principalId, userId);
            throw new UserAlreadyFollowerException();
        }
    }

    @Override
    @Transactional
    public void unfollow(Long principalId, Long userId) {
        userRepository.unfollow(principalId, userId);
    }

    @Override
    @Transactional
    public boolean isFollow(Long principalId, Long userId) {
        return userRepository.isFollow(principalId, userId) == 1;
    }
}
