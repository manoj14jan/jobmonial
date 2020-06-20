package com.genuinehire.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.genuinehire.domain.User;
import com.genuinehire.repository.UserRepository;
import com.genuinehire.scurity.CustomUserDetails;
import com.genuinehire.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);

		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {
			return new CustomUserDetails(user);
		}
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User addUser(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String userPass = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(userPass);
		user.setEnabled(1);
		return userRepository.save(user);
	}

}
