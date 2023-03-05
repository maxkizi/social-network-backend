package org.maxkizi.socialnetworkbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {
    @Column(name = "photo_url")
    private String userPhotoUrl;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "country")
    private String country;
    @Column(name = "status")
    private String status;
    @Column(name = "info")
    private String info;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_followers_binding",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id"))
    private Set<User> followers;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "followers")
    private Set<User> followed;

    private Set<User> getFollowed() {
        return followed;
    }
}
