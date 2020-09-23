package com.crudservice.org.daoImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crudservice.org.dao.DaoService;
import com.crudservice.org.model.Users;
import com.crudservice.org.repository.UsersRepository;

@Component
public class DaiServiceImp implements DaoService{
	
	@Autowired
	UsersRepository urepo;

	@Override
	public List<Users> getAllUsers() {
		
		 List<Users> l=(List<Users>) urepo.findAll();
		
		return l;
	}

	@Override
	public Users getUserById(int id) {
		
		Optional<Users> u=urepo.findById(id);
		Users uu=null;
		if(u.isPresent()) {
			uu=u.get();
		}
		return uu;
	}

	@Override
	public List<Users> delUserById(int id) {
		
		urepo.deleteById(id);
		 List<Users> l=(List<Users>) urepo.findAll();
			
		return l;
	}

	@Override
	public List<Users> addUser(Users u) {
		// TODO Auto-generated method stub
		urepo.save(u);
		 List<Users> l=(List<Users>) urepo.findAll();
		return l;
	}

	@Override
	public Users getAuth(String u, String p) {
		// TODO Auto-generated method stub
		Users user=urepo.findByUsernameAndPassword(u, p);
		return user;
	}

	

}
