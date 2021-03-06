package com.example.certif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.certif.model.User;
import com.example.certif.service.IUserService;

@RestController
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping("/users")
	public List<User> findUsers() {
		return userService.findAllUsers();
	}

}
