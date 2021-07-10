package com.kanakadurga.com.repository;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kanakadurga.com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
   
	@Query(value="select u from User u where u.username=?1")
	List<User> getUser(String name);
	
	//@Query(value="select * from testdb.user where user_name = ?1",nativeQuery=true)
	User findByUsername(String name);
	
}
