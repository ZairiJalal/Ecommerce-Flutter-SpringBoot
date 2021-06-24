package org.sid.repository;

import org.sid.entities.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<AppUser, String >{
	
	   AppUser findBy_id(String _id);

}
