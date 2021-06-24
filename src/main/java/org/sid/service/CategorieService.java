package org.sid.service;

import java.util.List;

import org.sid.entities.Categorie;

public interface CategorieService {
	
	Categorie save(Categorie categorie);
	List<Categorie> getAll();
	Categorie getOne(String _id);
	Void delete(String _id);

}
