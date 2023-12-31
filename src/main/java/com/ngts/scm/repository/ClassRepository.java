package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.ngts.scm.entity.Class;
public interface ClassRepository extends JpaRepository<Class, Integer>,JpaSpecificationExecutor<Class>{
	
	
	
}
