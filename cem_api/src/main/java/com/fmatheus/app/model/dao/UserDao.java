package com.fmatheus.app.model.dao;

import com.fmatheus.app.model.entity.UserEntity;
import com.fmatheus.app.model.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

/**
 *
 * @author fmatheus
 */
public abstract class UserDao implements GenericDao<UserEntity> {

    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity create(UserEntity t) {
        return repository.save(t);
    }

    @Override
    public UserEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<UserEntity> findAllOrderBy(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Optional<UserEntity> findByUsername(String username) {
        return repository.findByUsername(username);
    }

}
