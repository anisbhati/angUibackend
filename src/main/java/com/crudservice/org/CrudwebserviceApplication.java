package com.crudservice.org;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crudservice.org.dao.DaoService;
import com.crudservice.org.model.Users;
import com.crudservice.org.repository.UsersRepository;

@SpringBootApplication
public class CrudwebserviceApplication {

	@Autowired
    DaoService urepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CrudwebserviceApplication.class, args);
	}
	
//	@PostConstruct
//	public void addDefaultUser() {
//		Users u=new Users();
//		u.setUsername("user");
//		u.setPassword("user123");
//		u.setMail("user@asdf.com");
//		u.setMob(1212121212);
//		urepo.addUser(u);
//		
//	}

}
