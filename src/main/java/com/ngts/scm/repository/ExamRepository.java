package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>, JpaSpecificationExecutor<Exam> {

}
