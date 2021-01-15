package com.fmatheus.app.model.service.impl;

import com.fmatheus.app.model.entity.EmployeeEntity;
import com.fmatheus.app.model.repository.BaseRepositoryImpl;
import com.fmatheus.app.model.repository.EmployeeRepository;
import com.fmatheus.app.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fmatheus
 */
@Service
@Transactional
public class EmployeeServiceImpl extends BaseRepositoryImpl<EmployeeEntity, Integer> implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public EmployeeServiceImpl(EmployeeRepository repository) {
		super(repository);
	}

}
