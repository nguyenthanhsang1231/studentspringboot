package com.example.springboot.repository;

import com.example.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByClasssNameContaining (String className);
}
