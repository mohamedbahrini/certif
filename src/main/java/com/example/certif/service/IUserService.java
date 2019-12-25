package com.example.certif.service;

import java.util.List;

import com.example.certif.model.User;

public interface IUserService {
	public List<User> findAllUsers();
	public User findUserByUsername(String username);
}
