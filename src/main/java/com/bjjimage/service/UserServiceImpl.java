package com.bjjimage.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bjjimage.model.User;
import com.bjjimage.repository.UserRepository;
import com.bjjimage.security.MongoUserDetails;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



	@Override
	public User findUserByEmail(String email) {

		return userRepository.findByEmail(email);

	}

	@Override
	public void saveUser(User user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setAuthorities(new HashSet<String>(Arrays.asList("USER")));

		userRepository.save(user);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		
        if(user!=null) {

            MongoUserDetails mongoUserDetails = new MongoUserDetails(user.getEmail(),user.getPassword(),user.getAuthorities().toArray(new String[user.getAuthorities().size()]));

            return mongoUserDetails;

        }		
		
		return null;
	}

}
