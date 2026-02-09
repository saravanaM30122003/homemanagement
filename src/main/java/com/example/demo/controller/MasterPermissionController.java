package com.example.demo.controller;

import com.example.demo.entity.MasterPermission;
import com.example.demo.model.MasterPermissionModel;
import com.example.demo.service.MasterPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/master-permissions")
public class MasterPermissionController {

    @Autowired
    private MasterPermissionService masterPermissionService;

    @PostMapping
    public MasterPermission create(@RequestBody MasterPermissionModel model){
        return masterPermissionService.save(model);
    }

    @GetMapping
    public List<MasterPermission> getAll(){
        return masterPermissionService.getAll();
    }

    @GetMapping("/{id}")
    public MasterPermission getById(@PathVariable int id){
        return masterPermissionService.getById(id);
    }

    @PutMapping("/{id}")
    public MasterPermission update(@PathVariable int id,
                                   @RequestBody MasterPermissionModel model){
        return masterPermissionService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return masterPermissionService.delete(id);
    }
}
