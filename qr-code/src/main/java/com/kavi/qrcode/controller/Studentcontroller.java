package com.kavi.qrcode.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.kavi.qrcode.modal.student.Student;
import com.kavi.qrcode.service.StudentService;
import com.kavi.qrcode.utils.QRCodeGenerator;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class Studentcontroller {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents() throws IOException, WriterException {
		List<Student> students = studentService.getStudents();
		if(students.size() != 0) {
			for(Student stud : students) {
				QRCodeGenerator.generateQRCode(stud);
			}
		}
		return ResponseEntity.ok(studentService.getStudents());
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	@GetMapping("/{id}")
	public Student findById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
}
