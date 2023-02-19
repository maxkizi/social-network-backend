package org.maxkizi.socialnetworkbackend.repository;

import org.maxkizi.socialnetworkbackend.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Override
    @EntityGraph(attributePaths = {"posts"})
    Optional<User> findById(Long id);

    @Query(value = "select folowers.* from users u " +
            "inner join user_followers_binding ufb on u.id = ufb.user_id " +
            "inner join users folowers on ufb.follower_id = folowers.id where u.id = :principalId",
            nativeQuery = true)
    Optional<Set<User>> findFollowers(@Param(value = "principalId") Long principalId);

    @Query(value = "insert into user_followers_binding (user_id, follower_id) VALUES (:principalId, :userId)",
            nativeQuery = true)
    @Modifying
    void follow(@Param(value = "principalId") Long principalId,
                @Param(value = "userId") Long userId);

    @Query(value = "delete from user_followers_binding where user_id = :principalId and follower_id = :userId",
            nativeQuery = true)
    @Modifying
    void unfollow(@Param(value = "principalId") Long principalId,
                  @Param(value = "userId") Long userId);

    /**
     * Method returns 1 if user with userId follows user with principalId
     */
    @Query(value = "select count(*) from user_followers_binding where user_id = :principalId and follower_id = :userId",
            nativeQuery = true)
    int isFollow(@Param(value = "principalId") Long principalId,
                 @Param(value = "userId") Long userId);
}
