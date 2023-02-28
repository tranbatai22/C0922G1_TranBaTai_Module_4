package com.example.student.service;

import com.example.student.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> search(String searchName, String searchClazzName, Pageable pageable);

    List<Student> findAll();

    void save(Student student);

    void delete(int id);
}
