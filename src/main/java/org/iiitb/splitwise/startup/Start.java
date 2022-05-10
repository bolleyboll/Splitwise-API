package org.iiitb.splitwise.startup;

import org.iiitb.splitwise.model.User;
import org.iiitb.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

	@Autowired
	private UserRepository ur;
	
	@EventListener(ContextRefreshedEvent.class)
	public void bootUp() {
		System.out.println("Startup Starts");

		User u0 = new User();
		u0.setEmail("aman.gupta@iiitb.ac.in");
		u0.setUserId(0);
		u0.setUsername("bolleyboll");
		u0.setPassword("password");
		u0.setName("Aman Gupta");
		ur.save(u0);

		System.out.println("Startup End");

	}
}
