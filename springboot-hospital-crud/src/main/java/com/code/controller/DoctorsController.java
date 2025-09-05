package com.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.entity.Doctor;
import com.code.service.DoctorsService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class DoctorsController {

	@Autowired
	DoctorsService doctorsServices;
	
	@GetMapping("/doctor/{id}")
	public Doctor getDoctorById(@PathVariable long id) {
		return doctorsServices.getDoctorsById(id);
	}
	
	@GetMapping("/doctor")
	public List<Doctor> getAllDoctor( ){
		return doctorsServices.getAllDoctors();
	}
	
	@PostMapping("/doctor")
	public Doctor createDoctor(@RequestBody Doctor doctors) {
		return doctorsServices.createDoctor(doctors);
	}
	
	@PutMapping("/doctor/{id}")
	public Doctor updateDoctor(@PathVariable int id, @RequestBody Doctor doctors) {
		return doctorsServices.updateDoctor(id, doctors);
	}
	
	@DeleteMapping("/doctor/{id}")
	public void deleteDoctor(@PathVariable int id) {
		doctorsServices.deleteDoctor(id);
	}
}
