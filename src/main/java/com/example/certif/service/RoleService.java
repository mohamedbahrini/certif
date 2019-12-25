package com.example.certif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.certif.exception.RoleNameNotFoundException;
import com.example.certif.model.Role;
import com.example.certif.model.RoleName;
import com.example.certif.repository.RoleRepository;

@Service
public class RoleService implements IRoleService {
	
	private RoleRepository roleRepository;

	@Autowired
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> findAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role findRoleByName(RoleName roleName) {
		return roleRepository.findByRoleName(roleName).orElseThrow(()-> new RoleNameNotFoundException("roleName not found"));
	}

}
