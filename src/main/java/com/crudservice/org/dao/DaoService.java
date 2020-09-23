package com.crudservice.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudservice.org.model.Users;
import com.crudservice.org.repository.UsersRepository;

@Service
public interface DaoService {

	
	
	public List<Users>  getAllUsers();
	public Users getUserById(int id);
	public List<Users> delUserById(int id);
	public List<Users> addUser(Users u);
	public Users getAuth(String u,String p);
	
	
}
