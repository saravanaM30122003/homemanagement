package com.example.demo.repository;

import com.example.demo.entity.Expense;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
    List<Expense> findByUserUserId(Long userId);
}
