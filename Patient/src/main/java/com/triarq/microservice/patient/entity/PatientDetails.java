package com.triarq.microservice.patient.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PatientDetails {
	@JsonIgnore
	private Long patientId;

	private Patient patient;
	private List<Provider> providers;
	private List<Facility> facility;

	public PatientDetails() {
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public List<Facility> getFacility() {
		return facility;
	}

	public void setFacility(List<Facility> facility) {
		this.facility = facility;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "PatientDetails [patientId=" + patientId + ", patient=" + patient + ", providers=" + providers
				+ ", facility=" + facility + "]";
	}

	

	

}
