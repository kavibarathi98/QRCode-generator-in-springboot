package com.kavi.qrcode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kavi.qrcode.modal.student.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
