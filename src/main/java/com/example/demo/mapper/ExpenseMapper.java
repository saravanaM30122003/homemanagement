package com.example.demo.mapper;

import com.example.demo.entity.Expense;
import com.example.demo.model.ExpenseModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseMapper  {
    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    Expense toEntity(ExpenseModel expenseModel);
    ExpenseModel toModel(Expense expense);
}
