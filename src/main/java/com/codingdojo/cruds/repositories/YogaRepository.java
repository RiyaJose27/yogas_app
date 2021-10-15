package com.codingdojo.cruds.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cruds.models.Yoga;

@Repository


public interface YogaRepository extends CrudRepository<Yoga, Long> {

	List<Yoga> findAll();
	
	
}
