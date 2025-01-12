package com.eflyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eflyer.bean.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("FROM User WHERE userName = :username AND password = :password")
	public User login(String username, String password);
}
