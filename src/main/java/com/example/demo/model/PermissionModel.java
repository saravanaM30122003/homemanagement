package com.example.demo.model;

import com.example.demo.entity.Modules;
import com.example.demo.entity.User;


import java.util.List;

public class PermissionModel {

    private int p_Id;
    private User user;
    private String created_By;
    private String created_date;
    private String updated_date;
    private List<Integer> modules;
    private String read_Access;
    private String write_Access;
    private String delete_Access;
    private boolean isActive;

    public int getP_Id() {
        return p_Id;
    }

    public void setP_Id(int p_Id) {
        this.p_Id = p_Id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreated_By() {
        return created_By;
    }

    public void setCreated_By(String created_By) {
        this.created_By = created_By;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public List<Integer> getModules() {
        return modules;
    }

    public void setModules(List<Integer> modules) {
        this.modules = modules;
    }

    public String getRead_Access() {
        return read_Access;
    }

    public void setRead_Access(String read_Access) {
        this.read_Access = read_Access;
    }

    public String getWrite_Access() {
        return write_Access;
    }

    public void setWrite_Access(String write_Access) {
        this.write_Access = write_Access;
    }

    public String getDelete_Access() {
        return delete_Access;
    }

    public void setDelete_Access(String delete_Access) {
        this.delete_Access = delete_Access;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
