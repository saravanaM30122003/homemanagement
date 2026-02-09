package com.example.demo.controller;

import com.example.demo.entity.Permission;
import com.example.demo.model.PermissionModel;
import com.example.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public Permission create(@RequestBody PermissionModel model){
        return permissionService.createPermission(model);
    }


    @GetMapping
    public List<Permission> getAll(){
        return permissionService.getAllPermissions();
    }

    @GetMapping("/{id}")
    public Permission getById(@PathVariable int id){
        return permissionService.getPermissionById(id);
    }


    @PutMapping("/{id}")
    public Permission update(@PathVariable int id,
                             @RequestBody PermissionModel model){
        return permissionService.updatePermission(id, model);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return permissionService.deletePermission(id);
    }
}
