package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.model.RoleModel;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hapi/v1")
@CrossOrigin("*")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/saveRole")
    public RoleModel saveRole(@RequestBody RoleModel roleModel){
        return roleService.save(roleModel);
    }

    @DeleteMapping("/deletee")
    public void deleteRole(@RequestBody int id){
        roleService.delete(id);
    }

    @PutMapping("updateRole")
    public RoleModel updateRole(@RequestParam int id,@RequestBody RoleModel roleModel){
        return  roleService.update(id,roleModel);
    }

    @GetMapping("getAllRole")
    public List<Role> getAll (){
        return roleService.get_Roles();
    }
}
