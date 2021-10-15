package com.codingdojo.cruds.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.cruds.models.Yoga;
import com.codingdojo.cruds.repositories.YogaRepository;



@Service
public class YogaService {
	
	
	private YogaRepository yogaRepo;
	
	public YogaService(YogaRepository yogaRepo) {
		this.yogaRepo = yogaRepo;
	}

	
	public Yoga oneYoga(Long id ) {
		Optional<Yoga> optionalYoga = yogaRepo.findById(id);
		if(optionalYoga.isPresent()) {
			return optionalYoga.get();
		} else {
			return null;
		}
		
	}
	
	
	
	public Yoga create(Yoga yoga) {
		return yogaRepo.save(yoga);
	}
	
	
	public Yoga update(Yoga yoga) {
		return yogaRepo.save(yoga);
	}
	
	
	
	public void destroy(Long id) {
		yogaRepo.deleteById(id);
	}
	
	
	
	public List<Yoga> allYogas() {
		return yogaRepo.findAll();
	}
	
	
	
	
	
	
}
