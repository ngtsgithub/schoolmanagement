package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.entity.ClassRoutine;

public interface ClassRoutineRepository extends JpaRepository<ClassRoutine, Integer>, JpaSpecificationExecutor<ClassRoutine> {

}
