package com.yash.rbs.controller;

import com.yash.rbs.exception.UserNotFoundException;
import com.yash.rbs.model.AdminManager;
import com.yash.rbs.repository.AdminManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminManagerRepository userRepository;

    @PostMapping("/admin")
    AdminManager addAdmin(@RequestBody AdminManager admin) {
        return userRepository.save(admin);
    }

    @GetMapping("/admin/{id}")
    AdminManager getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    
  
    

    @PutMapping("/user/{id}")
    AdminManager updateUser(@RequestBody AdminManager newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }



}
