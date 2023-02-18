package org.maxkizi.socialnetworkbackend.repository;

import org.maxkizi.socialnetworkbackend.entity.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetailsImpl, Long> {
    Optional<UserDetails> findByUsername(String username);
}
