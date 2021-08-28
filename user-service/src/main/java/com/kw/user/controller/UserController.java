package com.kw.user.controller;

import com.kw.user.entity.User;
import com.kw.user.service.UserService;
import com.kw.user.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findByUserId(@PathVariable("id") Long userId){
        return userService.findByUserId(userId);
    }

    @GetMapping("/all")
    public List<User> findBAll(){
        return userService.findAll();
    }

    @GetMapping("/userDepartments/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id")  Long userId){
        return userService.getUserWithDepartment(userId);
    }
}
