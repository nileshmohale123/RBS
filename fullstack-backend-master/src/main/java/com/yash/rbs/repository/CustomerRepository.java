package com.yash.rbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.rbs.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
