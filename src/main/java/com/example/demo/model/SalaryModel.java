package com.example.demo.model;

public class SalaryModel {
    public int  current_Salary;
    public int last_month_salary;
    public int total_salary;
    public String date;
    public long user_id;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
