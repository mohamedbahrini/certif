package com.example.certif.bootstrap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.certif.exception.RoleNameNotFoundException;
import com.example.certif.model.Role;
import com.example.certif.model.RoleName;
import com.example.certif.model.User;
import com.example.certif.repository.RoleRepository;
import com.example.certif.repository.UserRepository;

@Component
public class InitDatabase implements CommandLineRunner {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public InitDatabase(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public void run(String... args) throws Exception {
		createRoles();
		createUsers();
	}


	private void createUsers() {
		if(!userRepository.existsByUsername("mohamed")) {
			User user = new User();
			user.setUsername("mohamed");
			user.setPassword(passwordEncoder.encode("123456789"));
			user.setRoles(Collections.singleton(roleRepository.findByRoleName(RoleName.ROLE_ADMIN).orElseThrow(() -> new RoleNameNotFoundException("rolename doesen't exist"))));
			userRepository.save(user);
		}
	}


	private void createRoles() {
		List<RoleName> roleNames = Arrays.asList(RoleName.ROLE_ADMIN, RoleName.ROLE_USER);
		roleNames.forEach(this::createRole);
	}


	private void createRole(RoleName roleName) {
		if(!roleRepository.existsByRoleName(roleName)) {
			Role role = new Role();
			role.setRoleName(roleName);
			roleRepository.save(role);
		}
	}
	
	

}
