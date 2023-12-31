package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ngts.scm.entity.Settings;

public interface SettingsRepository extends JpaRepository<Settings, Integer>, JpaSpecificationExecutor<Settings> {

}