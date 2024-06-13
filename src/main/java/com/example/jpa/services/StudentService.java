package com.example.jpa.services;

import com.example.jpa.entities.StudentEntity;

import java.util.List;

public interface StudentService {
    StudentEntity createStudent(StudentEntity studentEntity);

    List<StudentEntity> getAllStudents();
}
