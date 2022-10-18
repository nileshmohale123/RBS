package com.yash.rbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.rbs.model.AdminManager;
import com.yash.rbs.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{	

}

