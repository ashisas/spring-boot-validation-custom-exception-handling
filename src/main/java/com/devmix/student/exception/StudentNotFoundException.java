package com.devmix.student.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String msg) {
        super(msg);
    }
}
