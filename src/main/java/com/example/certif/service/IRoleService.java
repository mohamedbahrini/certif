package com.example.certif.service;

import java.util.List;

import com.example.certif.model.Role;
import com.example.certif.model.RoleName;

public interface IRoleService {
	public List<Role> findAllRoles();
	public Role findRoleByName(RoleName roleName);
}
