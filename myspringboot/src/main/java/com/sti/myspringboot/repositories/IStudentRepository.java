package com.sti.myspringboot.repositories;

import com.sti.myspringboot.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    Student findByAccountNumber(Long accountNumber);
}
