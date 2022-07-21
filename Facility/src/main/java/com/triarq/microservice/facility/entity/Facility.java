package com.triarq.microservice.facility.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facility")
public class Facility {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FacilityId;
	private String name;
	private String contact;
	private String email;
	private String address;
	private String city;
	private Long patientId;

	public Facility() {
	}

	public Facility(Long facilityId, String name, String contact, String email, String address, String city,
			Long patientId) {
		super();
		FacilityId = facilityId;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.city = city;
		this.patientId = patientId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getFacilityId() {
		return FacilityId;
	}

	public void setFacilityId(Long facilityId) {
		FacilityId = facilityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "Facility [FacilityId=" + FacilityId + ", name=" + name + ", contact=" + contact + ", email=" + email
				+ ", address=" + address + ", city=" + city + ", patientId=" + patientId + "]";
	}

}
