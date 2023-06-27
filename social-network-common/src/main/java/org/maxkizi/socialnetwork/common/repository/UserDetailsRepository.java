package org.maxkizi.socialnetwork.common.repository;

import org.maxkizi.socialnetwork.common.entity.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetailsImpl, Long> {
    Optional<UserDetails> findByUsername(String username);
}
