package com.fmatheus.app.model.repository;

import org.springframework.stereotype.Repository;

import com.fmatheus.app.model.entity.PersonEntity;

@Repository
public interface PersonRepositoy extends BaseRepository<PersonEntity, Integer> {

	PersonEntity findByDocument(String document);

}
