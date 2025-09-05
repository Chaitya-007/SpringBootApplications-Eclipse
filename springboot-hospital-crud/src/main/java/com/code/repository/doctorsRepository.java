package com.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.entity.Doctor;

@Repository
public interface doctorsRepository extends JpaRepository<Doctor, Long> {

}
