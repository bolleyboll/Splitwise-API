package org.iiitb.splitwise.services;

import org.iiitb.splitwise.model.User;

public interface UserService {
	User saveUser(User user);

	void delUser(String username);

	User login(String email, String password);
}
