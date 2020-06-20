package com.genuinehire.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.genuinehire.domain.User;

public interface UserService extends UserDetailsService{
	public User addUser(User user);
	public User getUserByUsername(String username);
}
