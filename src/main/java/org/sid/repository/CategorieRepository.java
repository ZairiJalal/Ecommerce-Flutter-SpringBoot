package org.sid.repository;

import org.sid.entities.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategorieRepository extends MongoRepository<Categorie, String > {
	
	   Categorie findBy_id(String _id);


}
