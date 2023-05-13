package com.zoro.crm.dao;

import com.zoro.crm.exceptions.StudentNotFoundException;
import com.zoro.crm.models.Student;
import com.zoro.crm.services.StudentService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.merge(student);
    }

    @Override
    public Student getById(int id) {
        Student student = entityManager.find(Student.class, id);
        if(student == null){
            throw new StudentNotFoundException(id + " - does not exist in database!");
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        return entityManager.createQuery("from Student").getResultList();
    }

    @Override
    public Student deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        if(student == null) {
            throw new StudentNotFoundException(id + " - does not exist in the database!");
        }
        entityManager.remove(student);
        return student;
    }
}
