package com.example.demo.controller;

import com.example.demo.entity.Salary;
import com.example.demo.model.SalaryModel;
import com.example.demo.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Hapi/v1")
@CrossOrigin("*")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @PostMapping("/setSalary")
    public SalaryModel saveSalary(@RequestParam long id ,@RequestBody SalaryModel salaryModel){
       return salaryService.saveSalary(id,salaryModel);
    }

    @GetMapping("/user/{userId}")
    public List<Salary> getByUser(@PathVariable long userId) {
        return salaryService.getByUser(userId);
    }

    @GetMapping("/{userId}/{id}")
    public Salary get(@PathVariable long userId,@PathVariable int id) {
        return salaryService.getById(userId,id);
    }

    @PutMapping("/{userId}/{id}")
    public Salary update(@PathVariable long userId,@PathVariable int id, @RequestBody SalaryModel model) {
        return salaryService.updateSalary(userId,id, model);
    }

    @DeleteMapping("/{userId}/{id}")
    public String delete(@PathVariable long userId,@PathVariable int id) {
        salaryService.deleteSalary(userId,id);
        return "Salary deleted";
    }
}
