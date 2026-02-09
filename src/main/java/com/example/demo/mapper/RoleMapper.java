package com.example.demo.mapper;

import com.example.demo.entity.Role;
import com.example.demo.model.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toEntity(RoleModel roleModel);
    RoleModel toModel(Role role);
}
