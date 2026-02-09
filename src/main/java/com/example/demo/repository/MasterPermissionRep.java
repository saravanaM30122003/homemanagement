package com.example.demo.repository;

import com.example.demo.entity.MasterPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterPermissionRep extends JpaRepository<MasterPermission,Integer> {
}
