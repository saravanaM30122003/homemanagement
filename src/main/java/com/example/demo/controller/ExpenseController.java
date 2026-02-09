package com.example.demo.controller;

import com.example.demo.model.ExpenseModel;
import com.example.demo.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin("*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ExpenseModel saveExpense(@RequestBody ExpenseModel model) {
        return expenseService.saveExpense(model);
    }


    @GetMapping
    public List<ExpenseModel> getAllExpenses() {
        return expenseService.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<ExpenseModel> getExpensesByUser(@PathVariable long userId) {
        return expenseService.getById(userId);
    }

    @GetMapping("/{id}")
    public ExpenseModel getExpenseById(@PathVariable int id) {
        return expenseService.getExpenseById(id);
    }


    @PutMapping("/{id}")
    public ExpenseModel updateExpense(@PathVariable int id,
                                      @RequestBody ExpenseModel model) {
        return expenseService.updateExpense(id, model);
    }


    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable int id) {
        return expenseService.deleteExpense(id);
    }
}
