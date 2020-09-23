package com.crudservice.org.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudservice.org.dao.DaoService;
import com.crudservice.org.exceptions.UserNotFoundException;
import com.crudservice.org.model.Users;

@RestController
@CrossOrigin("*")
public class CrudController {
	
	@Autowired
	@Qualifier("daiServiceImp")
	DaoService dao;
	
	
	@RequestMapping("/test")
	public String getTest() {
		return " / test is tested .....";
	}
    
	@PostMapping("/users")
	public List<Users> addUsers(@RequestBody Users u){
		List<Users> l=dao.addUser(u);
		return l;
	}
	
	@PutMapping("/users")
	public List<Users> updateUser(@RequestBody Users u){
		List<Users> l=dao.addUser(u);
		return l;
	}
	
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		List<Users> l=dao.getAllUsers();
		return l;
	}
	
	@DeleteMapping("/users/{id}")
	public List<Users> deleteByUsers(@PathVariable int id){
		List<Users> l=dao.delUserById(id);
		return l;
	}
	
	@GetMapping("/users/{id}")
	public Users getUsersById(@PathVariable  int id){
		Users users=dao.getUserById(id);
		if(users==null) 
			throw new UserNotFoundException("id-"+id);
		
		return users;
	}
	
	@PostMapping("/users/login")
	public Users getAut(@RequestBody Users u) {
		System.out.println("in login ................................");
		String uname=u.getUsername();
		String upass=u.getPassword();
		Users user=dao.getAuth(uname, upass);
		if(user==null) { 
			//throw new UserNotFoundException("user not fount unauthorize acccess");
			return null;
		}else {
			
		}
		
		return  user;
	}
	
	
	
}
