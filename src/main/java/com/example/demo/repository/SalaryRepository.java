package com.example.demo.repository;

import com.example.demo.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Integer>{

    @Query("SELECT s FROM Salary s WHERE s.user.userId = :userId ORDER BY s.id DESC")
    List<Salary> findLastSalary(@Param("userId") long userId);


    List<Salary> findByUserUserId(long userId);

}
