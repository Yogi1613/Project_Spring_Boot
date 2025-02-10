package com.itv.ITV205FirstSpringbootApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itv.ITV205FirstSpringbootApp.model.User;
import com.itv.ITV205FirstSpringbootApp.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	 
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if(user==null)
			throw new UsernameNotFoundException("User Not Found");
		
		return new MyUserDecorator(user);
	}

}
