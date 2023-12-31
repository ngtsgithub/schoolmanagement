package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.entity.Mark;

public interface MarkRepository extends JpaRepository<Mark, Integer>, JpaSpecificationExecutor<Mark> {

}
