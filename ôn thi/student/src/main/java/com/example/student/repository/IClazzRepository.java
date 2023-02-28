package com.example.student.repository;

import com.example.student.model.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClazzRepository extends JpaRepository<Clazz, Integer> {
}
