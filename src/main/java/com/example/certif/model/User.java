package com.example.certif.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@ManyToMany
	@JoinTable(name = "users_roles", 
			joinColumns = {	@JoinColumn(referencedColumnName = "id", name = "user_id") }, 
			inverseJoinColumns = { @JoinColumn(referencedColumnName = "id", name = "role_id") })
	private Set<Role> roles = new HashSet<>();
}
