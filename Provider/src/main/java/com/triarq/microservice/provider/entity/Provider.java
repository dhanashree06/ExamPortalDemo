package com.triarq.microservice.provider.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long providerId;
	private String name;
	private String mobile;
	private String city;
	private String speciality;
	private Long patientId;

	public Provider() {
	}

	public Provider(Long providerId, String name, String mobile, String city, String speciality, Long patientId) {
		super();
		this.providerId = providerId;
		this.name = name;
		this.mobile = mobile;
		this.city = city;
		this.speciality = speciality;
		this.patientId = patientId;
	}

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", name=" + name + ", mobile=" + mobile + ", city=" + city
				+ ", speciality=" + speciality + ", patientId=" + patientId + "]";
	}

}
