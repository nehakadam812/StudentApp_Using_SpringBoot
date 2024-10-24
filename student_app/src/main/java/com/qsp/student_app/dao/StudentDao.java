package com.qsp.student_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.student_app.entity.Student2;
import com.qsp.student_app.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepository repo;

	public Student2 saveStudent(Student2 student) {
		return repo.save(student);
	}

	public Student2 updateStudent(Student2 student) {
		return repo.save(student);

	}

	public Student2 findStudentById(int id) {
		Optional<Student2> optional = repo.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}

	}
	public Student2 findbyStudentPhone(long phone) {
		return repo.findByPhone(phone);

	}

	public Student2 findbyStudentEmail(String email) {
		return repo.findByEmail(email);
		

	}


	public void deleteStudentById(int id) {
		repo.deleteById(id);

	}

	public List<Student2> findAllStudent() {
		return repo.findAll();

	}
}
