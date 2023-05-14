package com.zoro.crm.controllers;

import com.zoro.crm.exceptions.StudentNotFoundException;
import com.zoro.crm.models.Student;
import com.zoro.crm.models.errors.StudentErrorResponse;
import com.zoro.crm.services.StudentService;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("")
    public Student saveStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return student;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = studentService.getStudent(id);
        return student;
    }

    @GetMapping("")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @PutMapping("")
    public Student updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return student;
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }
}
