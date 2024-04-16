package com.kavi.qrcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavi.qrcode.modal.student.Student;
import com.kavi.qrcode.repo.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student	 getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Student  Not Found"));
	}
}
