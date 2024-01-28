package com.devmix.student.service;

import com.devmix.student.entity.StudentEntity;

public interface StudentService {

    public StudentEntity createStudent(StudentEntity studentEntity);
    public StudentEntity details(String id);
}
