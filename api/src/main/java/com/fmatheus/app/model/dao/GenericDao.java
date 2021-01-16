package com.fmatheus.app.model.dao;

import java.util.List;

/**
 *
 * @author fmatheus
 */
public interface GenericDao<T> {

    T create(T t);

    T findById(int id);

    List<T> findAllOrderBy(String orderBy);

    void deleteById(int id);

}
