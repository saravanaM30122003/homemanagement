package com.example.demo.config;

import com.example.demo.entity.Expense;
import com.example.demo.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    SalaryMapper salaryMapper(){
     return SalaryMapper.INSTANCE;
    }

    @Bean
    UserMapper userMapper(){
        return UserMapper.INSTANCE;
    }

    @Bean
    CategoryMapper categoryMapper(){
        return CategoryMapper.INSTANCE;
    }

    @Bean
    RoleMapper roleMapper(){
        return  RoleMapper.INSTANCE;
    }

    @Bean
    ExpenseMapper expenseMapper(){
        return ExpenseMapper.INSTANCE;
    }
}
