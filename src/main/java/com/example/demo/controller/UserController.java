package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Hapi/v1")
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping("/saveUser")
  public UserModel saveUser(@RequestBody UserModel userModel){
      return  userService.saveUser(userModel);
  }

  @GetMapping("/getById")
  public UserModel getById(@RequestParam long id){
    return userService.getById(id);
  }

  @GetMapping("/getAll")
  public List<UserModel> getAll(){
    return userService.getAll();
  }

  @DeleteMapping("/deleteById")
  public String deleteById(@RequestParam long id){
    return userService.deleteUser(id);
  }

  @PutMapping("/updateUser")
  public UserModel updateUser(@RequestBody UserModel userModel){
    return userService.updateUser(userModel.getUserId(),userModel);
  }
}
