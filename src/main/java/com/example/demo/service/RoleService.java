package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.model.RoleModel;
import com.example.demo.repository.RoleRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMapper roleMapper;

    public RoleModel save (RoleModel roleModel){
      return roleMapper.toModel(roleRepository.save(roleMapper.toEntity(roleModel)));
    }


    public List<Role> get_Roles () {
        List<Role> role  = roleRepository.findAll();
        return role;
    }

    public RoleModel update (int id,RoleModel roleModel){
        Optional<Role> role =  roleRepository.findById(id);

        if(!role.isEmpty()){
            throw  new RuntimeException("Role not found");
        }
        if(!roleModel.getRoleName().isEmpty() && roleModel.getRoleName() != null){
            role.get().setRoleName(roleModel.getRoleName());
        }
       return roleMapper.toModel(roleRepository.save(role.get()));
    }

    public void delete(int id){
        roleRepository.deleteById(id);
    }

}
