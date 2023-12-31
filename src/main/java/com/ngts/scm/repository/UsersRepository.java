package com.ngts.scm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ngts.scm.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {

	Optional<Users> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}