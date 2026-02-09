package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MasterPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int m_id;
    private String roles;
    @ManyToMany
    @JoinTable(
            name = "masterpermission_modules",
            joinColumns = @JoinColumn(name = "master_permission_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<Modules> modules;
    private String readAccess;
    private String writeAccess;
    private String deleteAccess;

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<Modules> getModules() {
        return modules;
    }

    public void setModules(List<Modules> modules) {
        this.modules = modules;
    }

    public String getReadAccess() {
        return readAccess;
    }

    public void setReadAccess(String readAccess) {
        this.readAccess = readAccess;
    }

    public String getWriteAccess() {
        return writeAccess;
    }

    public void setWriteAccess(String writeAccess) {
        this.writeAccess = writeAccess;
    }

    public String getDeleteAccess() {
        return deleteAccess;
    }

    public void setDeleteAccess(String deleteAccess) {
        this.deleteAccess = deleteAccess;
    }
}
