package org.sid.service;

import java.util.List;

import javax.transaction.Transactional;

import org.sid.entities.AppUser;
import org.sid.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service @Transactional
public class AppUserServiceImpl implements AppUserService{

	@Autowired private AppUserRepository appUserRepository;
	
	@Override
	public AppUser save(AppUser appUser) {
		return appUserRepository.save(appUser);
	}

	@Override
	public List<AppUser> getAll() {
		return appUserRepository.findAll();
	}

	@Override
	public AppUser getOne(String _id) {
		return appUserRepository.findBy_id(_id);
	}

	@Override
	public Void delete(String _id) {
	    appUserRepository.deleteById(_id);;
		return null;
	}

	

}
