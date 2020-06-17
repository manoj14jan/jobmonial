package com.genuinehire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.genuinehire.domain.User;
import com.genuinehire.repository.AdminRepository;
import com.genuinehire.repository.UserRepository;
import com.genuinehire.scurity.CustomUserDetails;
import com.genuinehire.service.AdminService;
import com.genuinehire.service.UserService;

public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRespository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = adminRespository.findByUsername(username);

		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {
			return new CustomUserDetails(user);
		}
	}
	
	@Override
	public User getUserByUsername(String username) {

		User user = adminRespository.findByUsername(username);

		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {
			return  user;
		}
	}

}
