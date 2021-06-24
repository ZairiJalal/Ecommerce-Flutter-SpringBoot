package org.sid.repository;

import org.sid.entities.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProviderRepository extends MongoRepository<Provider, String >{
	
	   Provider findBy_id(String _id);


}
