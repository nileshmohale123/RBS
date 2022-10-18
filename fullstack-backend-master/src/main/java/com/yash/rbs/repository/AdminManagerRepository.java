package com.yash.rbs.repository;

import com.yash.rbs.model.AdminManager;
import com.yash.rbs.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminManagerRepository extends JpaRepository<AdminManager,Long> {


	
}
