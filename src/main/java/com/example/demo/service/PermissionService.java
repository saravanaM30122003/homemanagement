package com.example.demo.service;

import com.example.demo.entity.Modules;
import com.example.demo.entity.Permission;
import com.example.demo.model.PermissionModel;
import com.example.demo.repository.ModulesRepository;
import com.example.demo.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    ModulesRepository modulesRepository;


    public Permission createPermission(PermissionModel model){
        Permission permission = new Permission();

        permission.setUser(model.getUser());
        permission.setCreated_By(model.getCreated_By());
        permission.setCreated_date(model.getCreated_date());
        permission.setUpdated_date(model.getUpdated_date());
        if(!model.getModules().isEmpty()) {
            List<Modules> modules = modulesRepository.findAllById(model.getModules());
            permission.setModules(modules);
        }
        permission.setRead_Access(model.getRead_Access());
        permission.setWrite_Access(model.getWrite_Access());
        permission.setDelete_Access(model.getDelete_Access());
        permission.setActive(model.isActive());

        return permissionRepository.save(permission);
    }


    public List<Permission> getAllPermissions(){
        return permissionRepository.findAll();
    }


    public Permission getPermissionById(int id){
        return permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
    }


    public Permission updatePermission(int id, PermissionModel model){
        Permission permission = getPermissionById(id);

        permission.setUser(model.getUser());
        permission.setCreated_By(model.getCreated_By());
        permission.setCreated_date(model.getCreated_date());
        permission.setUpdated_date(model.getUpdated_date());
        if(!model.getModules().isEmpty()) {
            List<Modules> modules = modulesRepository.findAllById(model.getModules());
            permission.setModules(modules);
        }
        permission.setRead_Access(model.getRead_Access());
        permission.setWrite_Access(model.getWrite_Access());
        permission.setDelete_Access(model.getDelete_Access());
        permission.setActive(model.isActive());

        return permissionRepository.save(permission);
    }


    public String deletePermission(int id){
        permissionRepository.deleteById(id);
        return "Permission deleted successfully";
    }
}
