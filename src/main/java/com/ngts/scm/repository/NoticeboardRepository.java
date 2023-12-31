package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.entity.Noticeboard;

public interface NoticeboardRepository
		extends JpaRepository<Noticeboard, Integer>, JpaSpecificationExecutor<Noticeboard> {

}