package com.triarq.microservice.patient.clients;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.triarq.microservice.patient.entity.Patient;
import com.triarq.microservice.patient.entity.Provider;


@FeignClient("provider")
public interface ProviderFeignClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "myProviderDetails", consumes = "application/json")
	List<Provider> getProviderDetails(@RequestBody Patient patientDetails);
}
