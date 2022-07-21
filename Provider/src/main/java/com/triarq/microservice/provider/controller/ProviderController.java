package com.triarq.microservice.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.triarq.microservice.provider.entity.PatientDetails;
import com.triarq.microservice.provider.entity.Provider;
import com.triarq.microservice.provider.repository.ProviderRepository;

@RestController
public class ProviderController {
	
	@Autowired
	private ProviderRepository providerRepository;
	

	@ResponseStatus(code=HttpStatus.CREATED, reason = "Provider data is inserted into DB")
	@PostMapping("/myProvider")
	public Provider createProvider(@RequestBody Provider provider) {
		System.out.println(provider);
		Provider pro =  providerRepository.save(provider);
		return pro;
	}

	//@ResponseStatus(code=HttpStatus.OK, reason = "data retrieved from DB")
	@PostMapping("/myProviderDetails")
	public List<Provider> getProviderDetails(@RequestBody PatientDetails patientDetails) {

		List<Provider> providers = providerRepository.findProviderByPatientId(patientDetails.getPatientId());
		if (providers != null) {
			return providers;

		} else {
			return null;
		}

	}

}
