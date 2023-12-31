package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.entity.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer>, JpaSpecificationExecutor<UserRoles> {

}
