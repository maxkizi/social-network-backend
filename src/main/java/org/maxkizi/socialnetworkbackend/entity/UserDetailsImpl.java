package org.maxkizi.socialnetworkbackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Collections;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@DynamicUpdate
@Table(name = "users")
@Entity
public class UserDetailsImpl extends BaseEntity implements UserDetails {
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column (name = "is_account_non_expired")
    private boolean isAccountNonExpired;
    @Column (name = "is_account_non_locked")
    private boolean isAccountNonLocked;
    @Column(name = "is_credentials_non_expired")
    private boolean isCredentialsNonExpired;
    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.EMPTY_SET;
    }}
