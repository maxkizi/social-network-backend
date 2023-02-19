package org.maxkizi.socialnetworkbackend.service;

public interface FollowerService {
    void follow(Long principalId, Long userId);

    void unfollow(Long principalId, Long userId);

    boolean isFollow(Long principalId, Long userId);

}
