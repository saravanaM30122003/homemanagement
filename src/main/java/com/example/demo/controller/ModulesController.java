package com.example.demo.controller;

import com.example.demo.entity.Modules;
import com.example.demo.model.ModulesModel;
import com.example.demo.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModulesController {

    @Autowired
    private ModulesService modulesService;

    @PostMapping
    public Modules create(@RequestBody ModulesModel model){
        return modulesService.createModule(model);
    }


    @GetMapping
    public List<Modules> getAll(){
        return modulesService.getAllModules();
    }

    @GetMapping("/{id}")
    public Modules getById(@PathVariable int id){
        return modulesService.getModuleById(id);
    }

    @PutMapping("/{id}")
    public Modules update(@PathVariable int id,
                          @RequestBody ModulesModel model){
        return modulesService.updateModule(id, model);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return modulesService.deleteModule(id);
    }
}
