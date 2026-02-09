package com.example.demo.model;

public class ExpenseModel {
    public String type;
    public int e_amount;
    public String e_date;
    public long user_id;

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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
