package com.qsp.student_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.qsp.student_app.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	public List<Subject> findBytrainerName(String trainerName);
	   public List<Subject> findByName(String name);
	
}
