package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User saveUser(UserRequest userRequest)
	{
		User user = User.build(0, userRequest.getName(),
				userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), 
				userRequest.getAge(), userRequest.getNationality());
		
		return userRepository.save(user);
		
	}
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public User getUser(int id) throws UserException
	{
	 User user= userRepository.findByUserId(id);
	
		if(user!=null)
		 {
			 return user;
		 }
		 else
		 {
			 throw new UserException("User not found with id : "+id);
		 }
	 
	//return user;
	}

}
