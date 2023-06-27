package org.maxkizi.socialnetwork.base.service.impl;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetwork.base.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetwork.base.dto.ShortUserInfoDto;
import org.maxkizi.socialnetwork.base.exception.UserNotFoundException;
import org.maxkizi.socialnetwork.base.mapper.UserDtoConverter;
import org.maxkizi.socialnetwork.base.service.UserService;
import org.maxkizi.socialnetwork.common.entity.BaseEntity;
import org.maxkizi.socialnetwork.common.entity.User;
import org.maxkizi.socialnetwork.common.repository.UserDetailsRepository;
import org.maxkizi.socialnetwork.common.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("userServiceImpl")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final UserDtoConverter converter;

    @Override
    @Transactional
    public Page<ShortUserInfoDto> findAll(Pageable pageable, Long principalId) {
        Set<Long> followersIds = userRepository.findFollowers(principalId)
                .orElse(Collections.emptySet())
                .stream().map(BaseEntity::getId).collect(Collectors.toSet());
        Page<User> all = userRepository.findAll(pageable);
        List<ShortUserInfoDto> content = all.stream()
                .filter(u -> !u.getId().equals(principalId))
                .map(converter::toShortDto)
                .peek(dto -> {
                    if (followersIds.contains(dto.getId()))
                        dto.setFollower(true);
                }).collect(Collectors.toList());
        return new PageImpl<>(content, pageable, all.getTotalElements());
    }

    @Override
    @Transactional
    public ProfileUserInfoDto findById(Long id) {
        return converter.toDto(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    @Transactional
    public ProfileUserInfoDto save(ProfileUserInfoDto profileUserInfoDto) {
        return converter.toDto(userRepository.save(converter.toEntity(profileUserInfoDto)));
    }

    @Override
    @Transactional
    public ProfileUserInfoDto update(Long id, ProfileUserInfoDto profileUserInfoDto) {
        User foundUser = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        User userForSave = converter.toEntity(profileUserInfoDto);
        userForSave.setFollowers(foundUser.getFollowers());
        return converter.toDto(userRepository.save(userForSave));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }
}
