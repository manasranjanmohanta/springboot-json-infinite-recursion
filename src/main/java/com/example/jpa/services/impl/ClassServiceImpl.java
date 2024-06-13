package com.example.jpa.services.impl;

import com.example.jpa.entities.ClassEntity;
import com.example.jpa.repositories.ClassRepository;
import com.example.jpa.services.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public ClassEntity createClass(ClassEntity classEntity) {
        ClassEntity savedClassEntity = classRepository.save(classEntity);
        log.info("Saved class: {}", savedClassEntity);
        return savedClassEntity;
    }

    @Override
    public List<ClassEntity> getAllClasses() {
        List<ClassEntity> allClassEntities = classRepository.findAll();
        log.info("All classes: {}", allClassEntities);
        return allClassEntities;
    }
}
