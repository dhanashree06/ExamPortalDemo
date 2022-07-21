package com.triarq.microservice.facility.entity;

public class PatientDetails {
	
	private Long PatientId;

	public PatientDetails() {}
	
	public PatientDetails(Long patientId) {
		super();
		PatientId = patientId;
	}

	public Long getPatientId() {
		return PatientId;
	}

	public void setPatientId(Long patientId) {
		PatientId = patientId;
	}
	
	

}
