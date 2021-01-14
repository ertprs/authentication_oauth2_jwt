package com.fmatheus.app.model.repository;

import com.fmatheus.app.model.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fmatheus
 */
@Repository
public interface EmployeeRepository extends BaseRepository<EmployeeEntity, Integer> {

}
