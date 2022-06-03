package com.aptech.t2010a.hellospring.repository;

import com.aptech.t2010a.hellospring.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
