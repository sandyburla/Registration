package com.sandeep.login.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sandeep.login.model.Register;
import com.sandeep.login.repository.LoginAndRegisterDao;

@Service
public class LoginAndRegisterService {

	@Autowired
	LoginAndRegisterDao loginAndRegisterDao;

	public Register createUser(@RequestBody Register register) {
		// TODO Auto-generated method stub
		return loginAndRegisterDao.save(register);
	}


	public List<Register> getAll() {
		// TODO Auto-generated method stub
		return loginAndRegisterDao.findAll();
	}


	public Register getid(int id) {
		// TODO Auto-generated method stub
		return loginAndRegisterDao.getOne(id);
	}
	
//	public UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException{
//		Register optionalusers = loginAndRegisterDao.findByName(userName);
//		GrantedAuthority authority = new SimpleGrantedAuthority(optionalusers.getStatus());
//		
//		UserDetails userDetails = (UserDetails)new User(optionalusers.getFirst_name(),
//				optionalusers.getPassword(), Arrays.asList(authority));
//		return userDetails;
//	}

	
}
