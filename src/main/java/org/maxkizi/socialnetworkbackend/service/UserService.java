package org.maxkizi.socialnetworkbackend.service;

import org.maxkizi.socialnetworkbackend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    User findById(Long id);

    User save(User user);

    User update(Long id, User user);

    void delete(Long id);

}
