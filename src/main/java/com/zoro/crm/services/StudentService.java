package com.zoro.crm.services;

import com.zoro.crm.exceptions.StudentNotFoundException;
import com.zoro.crm.models.Student;
import com.zoro.crm.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void addMultipleStudents(List<Student> students) {
        students.forEach(student -> studentRepository.save(student));
    }

    public Student getStudent(int id) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if(!studentOptional.isPresent()) {
            throw new StudentNotFoundException(id + " - does not exist in the database!");
        }

        return studentOptional.get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public Student deleteStudent(int id) {
        Student student = getStudent(id);
        studentRepository.delete(student);
        return student;
    }
}
