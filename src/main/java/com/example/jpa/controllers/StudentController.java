package com.example.jpa.controllers;

import com.example.jpa.entities.StudentEntity;
import com.example.jpa.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity studentEntity) {
        System.out.println("Received StudentEntity: " + studentEntity);
        System.out.println("Received ClassEntity: " + studentEntity.getAClassEntity());

        if (studentEntity.getAClassEntity() != null) {
            System.out.println("ClassEntity ID: " + studentEntity.getAClassEntity().getId());
        }
        StudentEntity response = studentService.createStudent(studentEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> response = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
