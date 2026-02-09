package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int  current_Salary;
    public int last_month_salary;
    public int total_salary;
    public String date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public int getCurrent_Salary() {
        return current_Salary;
    }

    public void setCurrent_Salary(int current_Salary) {
        this.current_Salary = current_Salary;
    }

    public int getLast_month_salary() {
        return last_month_salary;
    }

    public void setLast_month_salary(int last_month_salary) {
        this.last_month_salary = last_month_salary;
    }

    public int getTotal_salary() {
        return total_salary;
    }

    public void setTotal_salary(int total_salary) {
        this.total_salary = total_salary;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
