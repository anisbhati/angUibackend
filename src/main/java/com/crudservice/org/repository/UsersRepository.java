package com.crudservice.org.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crudservice.org.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer>{
     public Users findByUsernameAndPassword(String u,String p);
}
