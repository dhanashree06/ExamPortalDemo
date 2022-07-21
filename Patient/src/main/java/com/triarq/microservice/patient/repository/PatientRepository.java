package com.triarq.microservice.patient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.triarq.microservice.patient.entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

	Patient findByPatientId(Long patientId);

}
