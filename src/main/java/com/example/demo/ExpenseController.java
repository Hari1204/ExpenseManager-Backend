package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseRepository repository;

	@CrossOrigin(origins="http://localhost:4200/")
	@PostMapping("/addExpense")
	public Expense addExpense(@RequestBody Expense expense)
	{
		return repository.save(expense);
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping("/getExpense/{type}")
	public List<Expense> getExpense(@PathVariable String type)
	{
		return repository.getByType(type);
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@DeleteMapping("/deleteByid/{id}")
	public void deleteExpense(@PathVariable int id)
	{
		 repository.deleteById(id);
	}	
	
	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping("/getAmountSum/{type}")
	public long getAmountSum(@PathVariable String type)
	{
		return repository.sumByAmount(type);
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping("/Max/{type}")
	public long Max(@PathVariable String type)
	{
		return repository.getMax(type);
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping("/Min/{type}")
	public long Min(@PathVariable String type)
	{
		return repository.getMin(type);
	}

}
