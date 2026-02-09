package com.example.demo.mapper;

import com.example.demo.entity.Modules;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserModel userModel);

    @Mapping(source = "roles", target = "roleIds")
    UserModel toModel(User user);

    default List<Integer> mapRolesToRoleIds(Set<Role> roles) {
        if (roles == null) return null;
        return roles.stream()
                .map(Role::getId)
                .collect(Collectors.toList());
    }

    // Modules -> Integer
    default List<Integer> mapModulesToIds(List<Modules> modules) {
        if (modules == null) return null;
        return modules.stream()
                .map(Modules::getModule_Id)
                .collect(Collectors.toList());
    }

    // Integer -> Modules  (THIS FIXES YOUR ERROR)
    default List<Modules> map(List<Integer> ids) {
        if (ids == null) return null;
        return ids.stream().map(id -> {
            Modules m = new Modules();
            m.setModule_Id(id);
            return m;
        }).collect(Collectors.toList());
    }
}
