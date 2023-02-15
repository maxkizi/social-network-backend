package org.maxkizi.socialnetworkbackend;

import org.maxkizi.socialnetworkbackend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class TestDataProvider {
    public User buildUser(int i) {
        return User.builder()
                .info("info" + i)
                .userPhotoUrl("url" + i)
                .lastName("lastname" + i)
                .firstName("firstname" + i)
                .country("country" + i)
                .status("status" + i)
                .username("username" + i)
                .password("password" + i)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .build();
    }
}
