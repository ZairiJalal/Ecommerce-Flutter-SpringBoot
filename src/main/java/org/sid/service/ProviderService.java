package org.sid.service;

import java.util.List;

import org.sid.entities.Provider;

public interface ProviderService {
	
	Provider save(Provider provider);
	List<Provider> getAll();
	Provider getOne(String _id);
	Void delete(String _id);
}

