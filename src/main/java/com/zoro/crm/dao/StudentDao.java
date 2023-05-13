package com.zoro.crm.dao;

import com.zoro.crm.models.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDao {
    void save(Student student);

    Student getById(int id);

    List<Student> getAll();

    Student deleteById(int id);
}
