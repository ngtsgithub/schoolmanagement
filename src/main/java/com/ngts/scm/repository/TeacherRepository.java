package com.ngts.scm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.entity.Student;
import com.ngts.scm.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>, JpaSpecificationExecutor<Teacher> {
	
	List<Teacher> findByEmail(String email);

	

}
