package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	List<Expense> getByType(String type);

	@Query("select sum(ex.amount) from expenses as ex where ex.type = ?1 ")
	public long sumByAmount(String type);

	@Query("select max(ex.amount) from expenses as ex where ex.type = ?1 ")
	long getMax(String type);

	@Query("select min(ex.amount) from expenses as ex where ex.type = ?1 ")
	long getMin(String type);

}
