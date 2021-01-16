package com.fmatheus.app.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmatheus.app.model.entity.PersonEntity;
import com.fmatheus.app.model.repository.BaseRepositoryImpl;
import com.fmatheus.app.model.repository.PersonRepositoy;

/**
 *
 * @author fmatheus
 */
@Service
@Transactional
public class PersonServiceImpl extends BaseRepositoryImpl<PersonEntity, Integer> {

	@Autowired
	private PersonRepositoy repositoy;

	public PersonServiceImpl(PersonRepositoy repositoy) {
		super(repositoy);
	}

	public PersonEntity findByDocument(String document) {
		return repositoy.findByDocument(document);
	}

}
