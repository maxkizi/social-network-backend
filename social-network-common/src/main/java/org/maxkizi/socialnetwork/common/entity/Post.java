package org.maxkizi.socialnetwork.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@SuperBuilder(toBuilder = true)
@Entity
@DynamicUpdate
@Table(name = "posts")
@NoArgsConstructor
public class Post extends BaseEntity {
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
