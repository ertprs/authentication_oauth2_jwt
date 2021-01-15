package com.fmatheus.app.model.service.impl;

import com.fmatheus.app.model.entity.UserEntity;
import com.fmatheus.app.model.repository.BaseRepositoryImpl;
import com.fmatheus.app.model.repository.UserRepository;
import com.fmatheus.app.model.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fmatheus
 */
@Service
@Transactional
public class UserServiceImpl extends BaseRepositoryImpl<UserEntity, Integer>
        implements UserService {

    @Autowired
    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

   public Optional<UserEntity> findByUsername(String username) {
        return repository.findByUsername(username);
    }

}
