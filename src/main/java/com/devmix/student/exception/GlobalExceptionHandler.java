package com.devmix.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(StudentExistsException.class)
    public ResponseEntity<?> studentExistsException(StudentExistsException st) {

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.OK.value());
        errorDetails.setStatus(HttpStatus.OK.name());
        errorDetails.setErrMessage(st.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<>(errorDetails,HttpStatus.OK);

    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> studentNotFoundException(StudentNotFoundException st) {

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorDetails.setStatus(HttpStatus.NOT_FOUND.name());
        errorDetails.setErrMessage(st.getMessage());
        errorDetails.setTimeStamp(LocalDateTime.now());
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodValidation(MethodArgumentNotValidException st) {
        List<String> fieldsErrors  = st.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("status",HttpStatus.BAD_REQUEST.name());
        errorMap.put("statusCode",HttpStatus.BAD_REQUEST.value());
        errorMap.put("timeStamp",LocalDateTime.now());
        errorMap.put("errMessages",fieldsErrors);
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);

    }
}
