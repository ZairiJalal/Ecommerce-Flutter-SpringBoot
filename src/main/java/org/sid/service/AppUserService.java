package org.sid.service;

import java.util.List;

import org.sid.entities.AppUser;

public interface AppUserService {
	
	AppUser save(AppUser appUser);
	List<AppUser> getAll();
	AppUser getOne(String _id);
	Void delete(String _id);

}
