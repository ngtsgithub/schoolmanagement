package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.entity.Transport;

public interface TransportRepository extends JpaRepository<Transport, Integer>, JpaSpecificationExecutor<Transport> {

}
