package com.example.demo.model;

import java.util.List;

public class MasterPermissionModel {

    private int m_id;
    private String roles;

    /* module IDs coming from request */
    private List<Integer> moduleIds;

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

    public List<Integer> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<Integer> moduleIds) {
        this.moduleIds = moduleIds;
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
