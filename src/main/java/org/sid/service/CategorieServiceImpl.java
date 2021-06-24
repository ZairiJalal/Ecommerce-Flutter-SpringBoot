package org.sid.service;

import java.util.List;

import javax.transaction.Transactional;

import org.sid.entities.Categorie;
import org.sid.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class CategorieServiceImpl implements CategorieService {

	@Autowired private CategorieRepository categorieRepository;
	
	@Override
	public Categorie save(Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	@Override
	public List<Categorie> getAll() {
		return categorieRepository.findAll();
	}

	@Override
	public Categorie getOne(String _id) {
		return categorieRepository.findBy_id(_id);
	}

	@Override
	public Void delete(String _id) {
		categorieRepository.deleteById(_id);
		return null;
	}

}
