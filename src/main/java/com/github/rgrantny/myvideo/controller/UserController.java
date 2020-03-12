package com.github.rgrantny.myvideo.controller;


import com.github.rgrantny.myvideo.model.User;
import com.github.rgrantny.myvideo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable(value = "id")Integer userId) {
        return service.getById(userId);
    }

    @PostMapping("/")
    public User create (@Valid @RequestBody User user) {
        return service.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable (value = "id") Integer userId,
                       @Valid @RequestBody User user) {
        return service.update(userId, user);
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody User user){
        System.out.println("userController.login");
        System.out.println(user);
        User foundUser = service.login(user);
        if (foundUser != null)
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/{id}")
    public  User delete(@PathVariable (value = "id") Integer userId){
        return service.delete(userId);
    }
}
