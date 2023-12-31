package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.entity.Dormitory;


public interface DormitoryRepository extends JpaRepository<Dormitory, Integer>, JpaSpecificationExecutor<Dormitory> {

}
