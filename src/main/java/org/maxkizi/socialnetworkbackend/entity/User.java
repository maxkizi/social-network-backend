package org.maxkizi.socialnetworkbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "users")
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.REMOVE})
    private List<Post> posts;
}
