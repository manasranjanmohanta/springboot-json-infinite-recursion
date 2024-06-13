package com.example.jpa.services;

import com.example.jpa.entities.ClassEntity;

import java.util.List;

public interface ClassService {
    ClassEntity createClass(ClassEntity classEntity);

    List<ClassEntity> getAllClasses();
}
