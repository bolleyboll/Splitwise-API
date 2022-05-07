package org.iiitb.splitwise.controller;

import org.iiitb.splitwise.model.User;
import org.iiitb.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	private static final String ORIGIN_URL = "http://localhost:4200";

	@Autowired
	private UserService us;

	@CrossOrigin(origins = ORIGIN_URL)
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		User u = us.saveUser(user);
		if (u!=null) {
			return ResponseEntity.ok(u.getUsername());
		} else {
			return ResponseEntity.ok("User already exists!");
		}

	}
}
