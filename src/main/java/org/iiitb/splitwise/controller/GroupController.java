package org.iiitb.splitwise.controller;

import java.util.List;

import org.iiitb.splitwise.model.Group;
import org.iiitb.splitwise.services.GroupService;
import org.iiitb.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("group")
@Slf4j
public class GroupController {

	@Autowired
	private GroupService gs;

	@GetMapping("{id}")
	public ResponseEntity<Group> groupDetails(@PathVariable Integer id) {
		return ResponseEntity.ok(gs.groupDetails(id));
	}

	@PostMapping("create")
	public ResponseEntity<String> createGroup(@RequestBody Group group){
		return ResponseEntity.ok(gs.createGroup(group).getName());
	}
	
}
