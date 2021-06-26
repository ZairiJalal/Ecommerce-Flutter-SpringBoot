package org.sid.service;

import java.util.List;

import org.sid.entities.New;

public interface NewService {

	New save(New n);
	List<New> getAll();
	List<New> getByCategorie(String categorie);
	New getOne(String _id);
	Void delete(String _id);
}
