package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.Salary;
import com.example.demo.entity.User;

import com.example.demo.exceptionhandler.AccessDeniedException;
import com.example.demo.mapper.SalaryMapper;
import com.example.demo.model.SalaryModel;
import com.example.demo.repository.SalaryRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SalaryMapper salaryMapper;

    public SalaryModel saveSalary(long userId, SalaryModel salaryModel) {
        User userroles = userRepository.findUserWithRoles(userId);
        boolean isAdmin = false;
        for (Role role : userroles.getRoles()) {
            if("admin".equalsIgnoreCase(role.getRoleName())){
               isAdmin = true;
               break;
            }
        }

        if(!isAdmin){
            throw new AccessDeniedException("Only ADMIN can add salary");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Salary> salaries = salaryRepository.findLastSalary(userId);


        int lastMonthSalary = 0;

        if (!salaries.isEmpty()) {
            lastMonthSalary = salaries.get(0).getTotal_salary();
        }

        int currentSalary = salaryModel.current_Salary;
        int totalSalary = lastMonthSalary + currentSalary;

        Salary salary = new Salary();
        salary.setCurrent_Salary(currentSalary);
        salary.setLast_month_salary(lastMonthSalary);
        salary.setTotal_salary(totalSalary);
        salary.setDate(salaryModel.date);
        salary.setUser(user);

        salaryRepository.save(salary);


        salaryModel.last_month_salary = lastMonthSalary;
        salaryModel.total_salary = totalSalary;

        return salaryModel;
    }

    public List<Salary> getByUser(long userId) {
        return salaryRepository.findByUserUserId(userId);
    }

    public Salary getById(long userId,int id) {
        User userRoles =  userRepository.findUserWithRoles(userId);
        boolean isAdmin = false;
        for(Role role : userRoles.getRoles()){
            if("admin".equalsIgnoreCase(role.getRoleName())){
                isAdmin = true;
                break;
            }
        }
        if (isAdmin){
            throw new AccessDeniedException("Only admin can access");
        }
        return salaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salary not found"));
    }

    public Salary updateSalary(long userId,int id, SalaryModel model) {
        User userRoles =  userRepository.findUserWithRoles(userId);
        boolean isAdmin = false;
        for(Role role : userRoles.getRoles()){
            if("admin".equalsIgnoreCase(role.getRoleName())){
                isAdmin = true;
                break;
            }
        }
        if (isAdmin){
            throw new AccessDeniedException("Only admin can access");
        }
        Salary salary = salaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salary not found"));

        salary.setCurrent_Salary(model.current_Salary);
        salary.setDate(model.date);

        int newTotal = salary.getLast_month_salary() + model.current_Salary;
        salary.setTotal_salary(newTotal);

        return salaryRepository.save(salary);
    }

    public void deleteSalary(long userId,int id) {
        User userRoles =  userRepository.findUserWithRoles(userId);
        boolean isAdmin = false;
        for(Role role : userRoles.getRoles()){
            if("admin".equalsIgnoreCase(role.getRoleName())){
                isAdmin = true;
                break;
            }
        }
        if (isAdmin){
            throw new AccessDeniedException("Only admin can access");
        }
        salaryRepository.deleteById(id);
    }

}
