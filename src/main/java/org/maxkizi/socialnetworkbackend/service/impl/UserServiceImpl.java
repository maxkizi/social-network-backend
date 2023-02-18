package org.maxkizi.socialnetworkbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.maxkizi.socialnetworkbackend.dto.ProfileUserInfoDto;
import org.maxkizi.socialnetworkbackend.dto.ShortUserInfoDto;
import org.maxkizi.socialnetworkbackend.exception.UserNotFoundException;
import org.maxkizi.socialnetworkbackend.mapper.UserDtoConverter;
import org.maxkizi.socialnetworkbackend.repository.UserDetailsRepository;
import org.maxkizi.socialnetworkbackend.repository.UserRepository;
import org.maxkizi.socialnetworkbackend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userServiceImpl")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final UserDtoConverter converter;

    @Override
    @Transactional
    public Page<ShortUserInfoDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(converter::toShortDto);
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
        userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return converter.toDto(userRepository.save(converter.toEntity(profileUserInfoDto)));
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
