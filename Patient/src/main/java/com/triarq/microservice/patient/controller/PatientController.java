package com.triarq.microservice.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.triarq.microservice.patient.clients.FacilityFeignClient;
import com.triarq.microservice.patient.clients.ProviderFeignClient;
import com.triarq.microservice.patient.entity.Facility;
import com.triarq.microservice.patient.entity.Patient;
import com.triarq.microservice.patient.entity.PatientDetails;
import com.triarq.microservice.patient.entity.Provider;
import com.triarq.microservice.patient.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ProviderFeignClient providerFeignClient;
	
	@Autowired
	private FacilityFeignClient facilityFeignClient;
	
	@ResponseStatus(code=HttpStatus.CREATED, reason = "data inserted into DB")
	@PostMapping("/myPatient")
	public Patient createPatient(@RequestBody Patient patient) {
		System.out.println(patient);
		Patient pat =  patientRepository.save(patient);
		return pat;
	}

	// @ResponseStatus(code=HttpStatus.OK, reason = "data retrieved from DB")
	@PostMapping("/myPatientDetails")
	public Patient getPatientDetails(@RequestBody PatientDetails patientDetails) {
		Patient patients = patientRepository.findByPatientId(patientDetails.getPatientId());
		if (patients != null) {
			return patients;
		} else {
			return null;
		}
	}
	
	@PostMapping("/myPatientAllData")
	public PatientDetails PatientAllData(@RequestBody Patient pat1) {
		Patient pat = patientRepository.findByPatientId(pat1.getPatientId());
		//System.out.println(pat);
		List<Provider> prov = providerFeignClient.getProviderDetails(pat1);
		List<Facility> fac = facilityFeignClient.getFacilityDetails(pat1);	
		PatientDetails pd = new PatientDetails();
		pd.setPatient(pat);
		pd.setProviders(prov);
		pd.setFacility(fac);
		return pd;
	}
	}

