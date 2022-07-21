package com.triarq.microservice.facility.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.triarq.microservice.facility.entity.Facility;

@Repository
public interface FacilityRepository extends CrudRepository<Facility, Long> {

	List<Facility> findFacilityByPatientId(Long patientId);

}
