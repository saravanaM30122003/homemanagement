package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Modules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int module_Id;

    private String module_Name;

    @ManyToMany(mappedBy = "modules")
    private List<Permission> permissions;

    @ManyToMany(mappedBy = "modules")
    private List<MasterPermission> masterPermissions;

    public List<MasterPermission> getMasterPermissions() {
        return masterPermissions;
    }

    public void setMasterPermissions(List<MasterPermission> masterPermissions) {
        this.masterPermissions = masterPermissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public int getModule_Id() {
        return module_Id;
    }

    public void setModule_Id(int module_Id) {
        this.module_Id = module_Id;
    }

    public String getModule_Name() {
        return module_Name;
    }

    public void setModule_Name(String module_Name) {
        this.module_Name = module_Name;
    }
}
