package org.sid.repository;

import org.sid.entities.New;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewRepository extends MongoRepository<New, String > {
	
	   New findBy_id(String _id);


}
