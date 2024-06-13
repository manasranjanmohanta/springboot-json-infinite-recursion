package com.example.jpa.services.impl;

import com.example.jpa.entities.ClassEntity;
import com.example.jpa.entities.StudentEntity;
import com.example.jpa.repositories.ClassRepository;
import com.example.jpa.repositories.StudentRepository;
import com.example.jpa.services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    public StudentServiceImpl(StudentRepository studentRepository, ClassRepository classRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
    }

    @Override
    public StudentEntity createStudent(StudentEntity studentEntity) {
        if (studentEntity.getAClassEntity() == null || studentEntity.getAClassEntity().getId()== null) {
            throw new IllegalArgumentException("ClassEntity or ClassEntity ID cannot be null");
        }
        Long classId = studentEntity.getAClassEntity().getId();
        ClassEntity classEntity = classRepository.findById(classId)
                .orElseThrow(() -> new IllegalArgumentException("Class not found with id: " + classId));
        studentEntity.setAClassEntity(classEntity);
        StudentEntity savedStudentEntity = studentRepository.save(studentEntity);
        log.info("Saved student: {}", savedStudentEntity);
        return savedStudentEntity;
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> allStudentEntities = studentRepository.findAll();
        log.info("All students: {}", allStudentEntities);
        return allStudentEntities;
    }
}
