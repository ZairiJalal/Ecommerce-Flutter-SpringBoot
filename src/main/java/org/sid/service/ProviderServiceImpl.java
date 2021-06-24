package org.sid.service;

import java.util.List;

import javax.transaction.Transactional;

import org.sid.entities.Provider;
import org.sid.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Transactional
public class ProviderServiceImpl  implements ProviderService{

	@Autowired private ProviderRepository providerRepository;
	
	@Override
	public Provider save(Provider provider) {
		return providerRepository.save(provider);
	}

	@Override
	public List<Provider> getAll() {
		return providerRepository.findAll();
	}

	@Override
	public Provider getOne(String _id) {
		return providerRepository.findBy_id(_id);
	}

	@Override
	public Void delete(String _id) {
		providerRepository.deleteById(_id);
		return null;
	}

}
