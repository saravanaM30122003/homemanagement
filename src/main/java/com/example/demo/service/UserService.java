package com.example.demo.service;

import com.example.demo.entity.Modules;
import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.PermissionModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.ModulesRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ModulesRepository modulesRepository;


    public UserModel saveUser(UserModel userModel) {
        User user = new User();
        user.setUserName(userModel.getUserName());
        user.setUserPassword(userModel.getUserPassword());
        user.setE_mail(userModel.getE_mail());
        user.setAge(userModel.getAge());
        user.setM_number(userModel.getM_number());
        Set<Role> roles = new HashSet<>();
        if (userModel.getRoleIds() != null) {
            for (Integer roleId : userModel.getRoleIds()) {
                Role role = roleRepository.findById(roleId)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                roles.add(role);
            }
        }
        user.setRoles(roles);
        if (userModel.getPermissions() != null) {
            List<Permission> permissionList = new ArrayList<>();
            for (PermissionModel pModel : userModel.getPermissions()) {
                Permission permission = new Permission();
                permission.setUser(user);
                permission.setActive(pModel.isActive());
                permission.setCreated_By(pModel.getCreated_By());
                permission.setCreated_date(pModel.getCreated_date());
                permission.setUpdated_date(pModel.getUpdated_date());
                permission.setDelete_Access(pModel.getDelete_Access());
                permission.setWrite_Access(pModel.getWrite_Access());
                permission.setRead_Access(pModel.getRead_Access());

                if (pModel.getModules() != null && !pModel.getModules().isEmpty()) {
                    List<Modules> modulesList =
                            modulesRepository.findAllById(pModel.getModules());
                    permission.setModules(modulesList);
                }
                permissionList.add(permission);
            }
            user.setPermissions(permissionList);
        }
        User savedUser = userRepository.save(user);
        return  userMapper.toModel(savedUser);
    }


    public UserModel getById(long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toModel(user);
    }

    public List<UserModel> getAll(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toModel)
                .toList();
    }

    public String deleteUser(long id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    public UserModel updateUser(long id, UserModel userModel){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(userModel.getUserName() != null && !userModel.getUserName().isEmpty()){
            user.setUserName(userModel.getUserName());
        }

        if(userModel.getUserPassword() != null && !userModel.getUserPassword().isEmpty()){
            user.setUserPassword(userModel.getUserPassword());
        }

        if(userModel.getE_mail() != null && !userModel.getE_mail().isEmpty()){
            user.setE_mail(userModel.getE_mail());
        }

        if(userModel.getM_number() != null && !userModel.getM_number().isEmpty()){
            user.setM_number(userModel.getM_number());
        }

        if(userModel.getAge() > 0){
            user.setAge(userModel.getAge());
        }

        if (userModel.getRoleIds() != null && !userModel.getRoleIds().isEmpty()) {
            Set<Role> roles = new HashSet<>();

            for (Integer roleId : userModel.getRoleIds()) {
                Role role = roleRepository.findById(roleId)
                        .orElseThrow(() -> new RuntimeException("Role not found"));
                roles.add(role);
            }
            user.setRoles(roles);
        }
        User updatedUser = userRepository.save(user);
        return userMapper.toModel(updatedUser);
    }
}
