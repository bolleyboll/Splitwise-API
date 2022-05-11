package org.iiitb.splitwise.services.impl;

import org.iiitb.splitwise.model.Expense;
import org.iiitb.splitwise.repositories.ExpenseRepository;
import org.iiitb.splitwise.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	private ExpenseRepository er;
	
	@Override
	public Expense add(Expense expense) {
		return er.save(expense);
	}
	
}
