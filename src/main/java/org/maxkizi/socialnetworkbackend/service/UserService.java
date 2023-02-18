package org.maxkizi.socialnetworkbackend.service;

import org.maxkizi.socialnetworkbackend.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetworkbackend.dto.ShortUserInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<ShortUserInfoDto> findAll(Pageable pageable);

    ProfileUserInfoDto findById(Long id);

    ProfileUserInfoDto save(ProfileUserInfoDto profileUserInfoDto);

    ProfileUserInfoDto update(Long id, ProfileUserInfoDto profileUserInfoDto);

    void delete(Long id);

}
