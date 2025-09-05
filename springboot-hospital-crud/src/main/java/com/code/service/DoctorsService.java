package com.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.entity.Doctor;
import com.code.repository.doctorsRepository;

@Service
public class DoctorsService {

	@Autowired
	doctorsRepository doctorsRepo;

	public Doctor getDoctorsById(long id) {
		return doctorsRepo.findById(id).orElse(null);
	}

	public List<Doctor> getAllDoctors() {
		return doctorsRepo.findAll();
	}

	public Doctor createDoctor(Doctor doctor) {
		return doctorsRepo.save(doctor);
	}

	public Doctor updateDoctor(long id, Doctor newdoctors) {
		Doctor doctor = doctorsRepo.findById(id).get();
		doctor.setName(newdoctors.getName());
		doctor.setEmail(newdoctors.getEmail());
		doctor.setContactNumber(newdoctors.getContactNumber());
		doctor.setGender(newdoctors.getGender());
		doctor.setConsultationFee(newdoctors.getConsultationFee());
		doctor.setExperienceYears(newdoctors.getExperienceYears());
		doctor.setSpecialization(newdoctors.getSpecialization());
		doctorsRepo.save(doctor);
		return doctor;
	}

	public void deleteDoctor(long id) {
		doctorsRepo.deleteById(id);
	}
}
