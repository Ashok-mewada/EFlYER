package com.eflyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eflyer.bean.User;
import com.eflyer.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		this.userRepository.save(user);
	}

	public User login(String username, String password) {
		return this.userRepository.login(username, password);
	}

}
