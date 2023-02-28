package com.example.student.repository;

import com.example.student.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select s.* from `student` s join `clazz` c on c.clazz_id = s.clazz_id where s.name like %:searchName% and c.clazz_name like %:searchClazzName%", nativeQuery = true)
    Page<Student> findByNameAndClazzName(@Param("searchName") String searchName, @Param("searchClazzName") String searchClazzName, Pageable pageable);
}
