package com.example.demo.mapper;
import com.example.demo.entity.Salary;
import com.example.demo.model.SalaryModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalaryMapper {
    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);
    Salary toEntity(SalaryModel salaryModel);
    SalaryModel toModel(Salary salary);
}
