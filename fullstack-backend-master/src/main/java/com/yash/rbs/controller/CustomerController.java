package com.yash.rbs.controller;

import java.util.List;

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
import com.yash.rbs.model.Customer;
import com.yash.rbs.repository.CustomerRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	

    @PostMapping("/customer")
    Customer addCustomer(@RequestBody Customer cust) {
        return customerRepository.save(cust);
    }

    @GetMapping("/customers")
    List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{cId}")
    Customer getCustomerById(@PathVariable Long cId) {
        return customerRepository.findById(cId)
                .orElseThrow(() -> new CustomerNotFoundException(cId));
    }

    @PutMapping("/customer/{cId}")
    Customer updateCustomer(@RequestBody Customer cust, @PathVariable Long cId) {
        return customerRepository.findById(cId)
                .map(newcust -> {
                	newcust.setName(cust.getName());
                	newcust.setEmail(cust.getEmail());
                	newcust.setAddress(cust.getAddress());
                	newcust.setPhone(cust.getPhone());
                	newcust.setNoOfAdult(cust.getNoOfAdult());
                	newcust.setNoOfAdult(cust.getNoOfAdult());
                	newcust.setRoomNo(cust.getRoomNo());
                	newcust.setDescription(cust.getDescription());
                	
                    return customerRepository.save(newcust);
                }).orElseThrow(() -> new CustomerNotFoundException(cId));
    }

    @DeleteMapping("/customer/{cId}")
    String deleteCustomer(@PathVariable Long cId){
        if(!customerRepository.existsById(cId)){
            throw new CustomerNotFoundException(cId);
        }
        customerRepository.deleteById(cId);
        return  "Customer with id "+cId+" has been deleted success.";
    }

}


