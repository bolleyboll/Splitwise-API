package org.iiitb.splitwise.services;

import org.iiitb.splitwise.model.Group;

public interface GroupService {
	Group groupDetails(Integer id);

	Group createGroup(Group group);
}
