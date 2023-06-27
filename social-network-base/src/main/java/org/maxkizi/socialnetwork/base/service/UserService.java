package org.maxkizi.socialnetwork.base.service;

import org.maxkizi.socialnetwork.base.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetwork.base.dto.ShortUserInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<ShortUserInfoDto> findAll(Pageable pageable, Long principalId);

    ProfileUserInfoDto findById(Long id);

    ProfileUserInfoDto save(ProfileUserInfoDto profileUserInfoDto);

    ProfileUserInfoDto update(Long id, ProfileUserInfoDto profileUserInfoDto);

    void delete(Long id);

}
