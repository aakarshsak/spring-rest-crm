package com.zoro.crm.services;

import com.zoro.crm.dao.StudentDao;
import com.zoro.crm.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Transactional
    public void addStudent(Student student) {
        studentDao.save(student);
    }

    @Transactional
    public void addMultipleStudents(List<Student> students) {
        students.forEach(student -> studentDao.save(student));
    }

    public Student getStudent(int id) {
        return studentDao.getById(id);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }

    @Transactional
    public void updateStudent(Student student) {
        studentDao.save(student);
    }

    @Transactional
    public Student deleteStudent(int id) {
        return studentDao.deleteById(id);
    }
}
