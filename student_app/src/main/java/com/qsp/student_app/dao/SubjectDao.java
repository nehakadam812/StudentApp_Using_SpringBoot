package com.qsp.student_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.qsp.student_app.entity.Subject;
import com.qsp.student_app.repository.SubjectRepository;

@Repository
public class SubjectDao {
	
	@Autowired
	SubjectRepository repo;


	public Subject saveSubject(Subject subject) {
		return repo.save(subject);
	}

	public Subject updateSubject(Subject subject) {
		return repo.save(subject);

	}

	public Subject findSubjectById(int id) {
		Optional<Subject> optional = repo.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}

	}
	
	public void deleteById(int id) {
		repo.deleteById(id);
		
	}
	public List<Subject> findAllSubject() {
		return repo.findAll();
		
	}

	
	public List<Subject> FIndByName(String name) {
		return repo.findByName(name);
		
	}
	
	public List<Subject> FIndByTrainerName(String trinerName) {
		return repo.findBytrainerName(trinerName);
				
		
	}
}
