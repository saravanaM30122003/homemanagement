package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int expense_id;
    public String type;
    public int e_amount;
    public String e_date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getE_amount() {
        return e_amount;
    }

    public void setE_amount(int e_amount) {
        this.e_amount = e_amount;
    }

    public String getE_date() {
        return e_date;
    }

    public void setE_date(String e_date) {
        this.e_date = e_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
