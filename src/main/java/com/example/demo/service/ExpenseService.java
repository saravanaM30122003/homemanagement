package com.example.demo.service;

import com.example.demo.entity.Expense;
import com.example.demo.entity.User;
import com.example.demo.mapper.ExpenseMapper;
import com.example.demo.model.ExpenseModel;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ExpenseMapper expenseMapper;

    public ExpenseModel saveExpense(ExpenseModel model) {
        User user = userRepository.findById(model.user_id)
                .orElseThrow(() -> new RuntimeException("User not found"));

         Expense expense = expenseMapper.toEntity(model);
         expense.setUser(user);
         return expenseMapper.toModel(expenseRepository.save(expense));
    }

    public List<ExpenseModel> getAll(){
        List<Expense> expenseList = expenseRepository.findAll();
        List<ExpenseModel> expenseModels = new ArrayList<>();
        for(Expense expense : expenseList){
            expenseModels.add(expenseMapper.toModel(expense));
        }
        return expenseModels;
    }

    public List<ExpenseModel> getById(long id){
        List<Expense> expenseList = expenseRepository.findByUserUserId(id);
        List<ExpenseModel> expenseModels = new ArrayList<>();
        for(Expense expense : expenseList){
            expenseModels.add(expenseMapper.toModel(expense));
        }
        return expenseModels;
    }


    public ExpenseModel getExpenseById(int id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        return expenseMapper.toModel(expense);
    }

    public ExpenseModel updateExpense(int expenseId, ExpenseModel model) {

        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        User user = userRepository.findById(model.user_id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        expense.setType(model.getType());
        expense.setE_amount(model.getE_amount());
        expense.setE_date(model.getE_date());
        expense.setUser(user);

        return expenseMapper.toModel(expenseRepository.save(expense));
    }

    public String deleteExpense(int expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expenseRepository.delete(expense);
        return "Expense deleted successfully";
    }

}
