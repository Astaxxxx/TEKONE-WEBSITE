package com.tekone.tekone.repository;

import org.springframework.data.repository.CrudRepository;

import com.tekone.tekone.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByName(String name);

}
