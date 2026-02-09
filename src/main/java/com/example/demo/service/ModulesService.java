package com.example.demo.service;

import com.example.demo.entity.Modules;
import com.example.demo.model.ModulesModel;
import com.example.demo.repository.ModulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulesService {

    @Autowired
    private ModulesRepository modulesRepository;

    public Modules createModule(ModulesModel model){
        Modules modules = new Modules();
        modules.setModule_Name(model.getModule_Name());
        return modulesRepository.save(modules);
    }

    public List<Modules> getAllModules(){
        return modulesRepository.findAll();
    }

    public Modules getModuleById(int id){
        return modulesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found"));
    }


    public Modules updateModule(int id, ModulesModel model){
        Modules modules = getModuleById(id);
        modules.setModule_Name(model.getModule_Name());
        return modulesRepository.save(modules);
    }


    public String deleteModule(int id){
        modulesRepository.deleteById(id);
        return "Module deleted successfully";
    }
}
