package org.iiitb.splitwise.repositories;

import org.iiitb.splitwise.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	Expense findByGroup(String group);
}
