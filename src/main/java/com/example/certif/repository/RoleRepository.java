package com.example.certif.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.certif.model.Role;
import com.example.certif.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByRoleName(RoleName roleName);
}
