package com.ngts.scm.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.dto.ParentDTO;
import com.ngts.scm.entity.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer>, JpaSpecificationExecutor<Parent> {

	Collection<ParentDTO> findByEmail(String email);

	
}
