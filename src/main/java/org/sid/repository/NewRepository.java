package org.sid.repository;

import java.util.List;

import org.sid.entities.New;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewRepository extends MongoRepository<New, String > {
	
	New findBy_id(String _id);
	List<New> findByCategorie(String categorie);

}
