package com.triarq.microservice.provider.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.triarq.microservice.provider.entity.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {

	List<Provider> findProviderByPatientId(Long patientId);
		
	

}
