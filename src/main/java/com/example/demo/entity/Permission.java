package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    private String created_By;
    private String created_date;
    private String updated_date;

    @ManyToMany
    @JoinTable(
            name = "permission_modules",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<Modules> modules;
    private String read_Access;
    private String write_Access;
    private String delete_Access;

    public List<Modules> getModules() {
        return modules;
    }

    public void setModules(List<Modules> modules) {
        this.modules = modules;
    }

    private boolean isActive;



    public int getP_Id() {
        return p_Id;
    }

    public String getCreated_By() {
        return created_By;
    }

    public void setCreated_By(String created_By) {
        this.created_By = created_By;
    }

    public void setP_Id(int p_Id) {
        this.p_Id = p_Id;
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



    public String getRead_Access() {
        return read_Access;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
