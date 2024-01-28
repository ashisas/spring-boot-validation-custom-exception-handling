package com.devmix.student.repo;

import com.devmix.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity,String > {
}
