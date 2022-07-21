package com.triarq.microservice.patient.clients;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.triarq.microservice.patient.entity.Facility;
import com.triarq.microservice.patient.entity.Patient;

@FeignClient("facility")
public interface FacilityFeignClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "myFacilityDetails", consumes = "application/json")
	List<Facility> getFacilityDetails(@RequestBody Patient patientDetails);

}
