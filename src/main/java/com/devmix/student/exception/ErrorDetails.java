package com.devmix.student.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {


    private int statusCode;
    private LocalDateTime timeStamp;
    private String errMessage;
    private String status;
}
