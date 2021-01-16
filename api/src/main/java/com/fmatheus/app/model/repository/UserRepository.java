package com.fmatheus.app.model.repository;

import com.fmatheus.app.model.entity.UserEntity;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fmatheus
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String username);

}
