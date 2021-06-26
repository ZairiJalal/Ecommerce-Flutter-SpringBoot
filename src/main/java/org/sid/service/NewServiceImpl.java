package org.sid.service;

import java.util.List;

import javax.transaction.Transactional;

import org.sid.entities.New;
import org.sid.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class NewServiceImpl implements NewService{

	@Autowired private NewRepository newRepository;
	
	@Override
	public New save(New n) {
		
		return newRepository.save(n);
	}

	@Override
	public List<New> getAll() {
		return newRepository.findAll();
	}

	@Override
	public New getOne(String _id) {
		return newRepository.findBy_id(_id);
	}

	@Override
	public Void delete(String _id) {
		newRepository.deleteById(_id);
		return null;
	}

	@Override
	public List<New> getByCategorie(String categorie) {
		return newRepository.findByCategorie(categorie);
	}

}
