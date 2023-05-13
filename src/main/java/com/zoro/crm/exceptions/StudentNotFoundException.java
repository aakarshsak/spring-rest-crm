package com.zoro.crm.exceptions;

import com.zoro.crm.models.errors.StudentErrorResponse;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }
}
