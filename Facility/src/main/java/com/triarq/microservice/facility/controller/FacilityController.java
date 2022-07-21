package com.triarq.microservice.facility.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.triarq.microservice.facility.entity.Facility;
import com.triarq.microservice.facility.entity.PatientDetails;
import com.triarq.microservice.facility.repository.FacilityRepository;

@RestController
public class FacilityController {

	@Autowired
	private FacilityRepository facilityRepository;

	@ResponseStatus(code = HttpStatus.CREATED, reason = "Facility data is inserted into DB")
	@PostMapping("/myFacility")
	public Facility createFacility(@RequestBody Facility facility) {
		System.out.println(facility);
		Facility faci = facilityRepository.save(facility);
		return faci;
	}

	@PostMapping("/myFacilityDetails")
	public List<Facility> getFacilityDetails(@RequestBody PatientDetails patientDetails) {

		List<Facility> facility = facilityRepository.findFacilityByPatientId(patientDetails.getPatientId());
		if (facility != null) {
			return facility;
		} else {
			return null;
		}

	}
}