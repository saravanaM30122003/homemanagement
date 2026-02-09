package com.example.demo.model;

public class BalanceModel {
    public Long total_income;
    public Long total_expense;
    public Long remaining_balance;
    public long user_id;

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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
