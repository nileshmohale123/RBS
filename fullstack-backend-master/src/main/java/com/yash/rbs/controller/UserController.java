package com.yash.rbs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.rbs.exception.CustomerNotFoundException;
import com.yash.rbs.exception.UserNotFoundException;
import com.yash.rbs.model.AdminManager;
import com.yash.rbs.model.Customer;
import com.yash.rbs.model.Status;
import com.yash.rbs.model.User;
import com.yash.rbs.repository.UserRepository;
@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    UserRepository userRepository;
    
   
    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser) {
        List<User> users = userRepository.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepository.save(newUser);
        return Status.SUCCESS;
    }
    
  
    
    @PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    
    @GetMapping("/users")
    List<User> getAllCustomer() {
        return userRepository.findAll();
    }
    
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id)
    {
    	return userRepository.findById(id)
    	.orElseThrow(()-> new CustomerNotFoundException(id));
    }
    
    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                userRepository.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    
    @PutMapping("/getuser/{cId}")
    User updateusersdata(@RequestBody User cust, @PathVariable Long cId) {
        return userRepository.findById(cId)
                .map(newcust -> {
                	
                	newcust.setLoggedIn(cust.isLoggedIn());
                	newcust.setEmail(cust.getEmail());
                	newcust.setUsername(cust.getUsername());
                	newcust.setPassword(cust.getPassword());
                	
                	
                    return userRepository.save(newcust);
                }).orElseThrow(() -> new CustomerNotFoundException(cId));
    }
    
    
    @DeleteMapping("/deleteuser/{id}")
    String deleteUser(@PathVariable Long id)
    {
    if(!userRepository.existsById(id))
    {
    	throw new CustomerNotFoundException(id);
    }
    userRepository.deleteById(id);
    return "User with id"+id+"has been deleted successfullty";
}
    
    @DeleteMapping("/users/all")
    public Status deleteUsers() 
    {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }
    
   
}
