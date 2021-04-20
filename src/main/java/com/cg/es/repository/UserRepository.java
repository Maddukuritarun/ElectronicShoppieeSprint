package com.cg.es.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.es.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

}
