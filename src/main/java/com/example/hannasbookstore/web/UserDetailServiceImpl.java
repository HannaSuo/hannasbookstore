package com.example.hannasbookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hannasbookstore.model.MyUser;
import com.example.hannasbookstore.model.UserRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository repository;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
	    	MyUser curruser = repository.findByUsername(username);
	        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
	        		AuthorityUtils.createAuthorityList(curruser.getRole()));
	        return user;
	    }   

}
