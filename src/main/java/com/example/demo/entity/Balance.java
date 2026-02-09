package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int b_id;
    public Long total_income;
    public Long total_expense;
    public Long remaining_balance;
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public Long getTotal_income() {
        return total_income;
    }

    public void setTotal_income(Long total_income) {
        this.total_income = total_income;
    }

    public Long getTotal_expense() {
        return total_expense;
    }

    public void setTotal_expense(Long total_expense) {
        this.total_expense = total_expense;
    }

    public Long getRemaining_balance() {
        return remaining_balance;
    }

    public void setRemaining_balance(Long remaining_balance) {
        this.remaining_balance = remaining_balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
