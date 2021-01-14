package com.fmatheus.app.model.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmatheus.app.model.entity.OccupationEntity;
import com.fmatheus.app.model.repository.BaseRepositoryImpl;
import com.fmatheus.app.model.repository.OccupationRepository;
import com.fmatheus.app.model.service.OccupationService;

@Service
@Transactional
public class OccupationServiceImpl extends BaseRepositoryImpl<OccupationEntity, Integer> implements OccupationService {

	public OccupationServiceImpl(OccupationRepository repository) {
		super(repository);
	}

}
