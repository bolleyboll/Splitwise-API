package org.iiitb.splitwise.services.impl;

import org.iiitb.splitwise.model.User;
import org.iiitb.splitwise.repositories.UserRepository;
import org.iiitb.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository ur;

	@Override
	public User saveUser(User user) {
		return ur.save(user);
	}

	@Override
	public void delUser(String username) {
		ur.deleteById(username);
	}
	
}
