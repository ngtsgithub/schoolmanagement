package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>, JpaSpecificationExecutor<Language> {

}