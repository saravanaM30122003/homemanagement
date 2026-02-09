package com.example.demo.service;

import com.example.demo.entity.MasterPermission;
import com.example.demo.entity.Modules;
import com.example.demo.model.MasterPermissionModel;
import com.example.demo.repository.MasterPermissionRep;
import com.example.demo.repository.ModulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterPermissionService {

    @Autowired
    private MasterPermissionRep masterPermissionRepository;

    @Autowired
    private ModulesRepository modulesRepository;


    public MasterPermission save(MasterPermissionModel model){

        MasterPermission entity = new MasterPermission();
        entity.setRoles(model.getRoles());
        entity.setReadAccess(model.getReadAccess());
        entity.setWriteAccess(model.getWriteAccess());
        entity.setDeleteAccess(model.getDeleteAccess());

        if(model.getModuleIds() != null){
            List<Modules> modules =
                    modulesRepository.findAllById(model.getModuleIds());
            entity.setModules(modules);
        }

        return masterPermissionRepository.save(entity);
    }


    public List<MasterPermission> getAll(){
        return masterPermissionRepository.findAll();
    }

    public MasterPermission getById(int id){
        return masterPermissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MasterPermission not found"));
    }


    public MasterPermission update(int id, MasterPermissionModel model){

        MasterPermission entity = getById(id);

        entity.setRoles(model.getRoles());
        entity.setReadAccess(model.getReadAccess());
        entity.setWriteAccess(model.getWriteAccess());
        entity.setDeleteAccess(model.getDeleteAccess());

        if(model.getModuleIds() != null){
            List<Modules> modules =
                    modulesRepository.findAllById(model.getModuleIds());
            entity.setModules(modules);
        }

        return masterPermissionRepository.save(entity);
    }

    public String delete(int id){
        masterPermissionRepository.deleteById(id);
        return "MasterPermission deleted successfully";
    }
}
