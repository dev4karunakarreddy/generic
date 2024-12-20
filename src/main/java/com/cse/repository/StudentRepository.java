package com.cse.repository;

import com.cse.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends BaseRepository<Student,Long> {

    Optional<Student> findByRoll(String roll);

}
