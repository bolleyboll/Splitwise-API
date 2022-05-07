package org.iiitb.splitwise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "expenses")
public class Expense {

	@Id
	@Column(name = "expenseId", unique = true, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer expenseId;

	@Column(name = "expenseName", length = 50, nullable = false)
	private String expenseName;

	@Column(name = "expenseAmount", length = 50, nullable = false)
	private Double expenseAmount;

	@JoinColumn(name = "groupId")
	@ManyToOne
	private Group group;

	@Column(name = "split", length = 50, nullable = false)
	private String split;
}
