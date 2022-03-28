package com.UserService.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserService.demo.client.UserClient;
import com.UserService.demo.dto.UserRequestDTO;
import com.UserService.demo.dto.UserResponseDTO;
import com.UserService.demo.entity.User;
import com.UserService.demo.repo.UserRepo;
import com.UserService.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired(required = false)
	UserClient userClient;
	
	@Autowired
	UserRepo userRepo;

	@Override
	public UserResponseDTO AuthenticateUser(UserRequestDTO userRequestDTO) {
		
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		
		UserRequestDTO userDB = userRepo.findByUsername(userRequestDTO.getUserName());
		
		if(userDB==null) {
			userResponseDTO.setMessage("User not found");
			userResponseDTO.setUserId(0);
			userResponseDTO.setStatusCode("200");
			
			return userResponseDTO;
		}
		if(!userDB.getPassword().equals(userRequestDTO.getPassword())) {
			userResponseDTO.setMessage("User not found");
			userResponseDTO.setUserId(0);
			userResponseDTO.setStatusCode("200");
			
			return userResponseDTO;
		}
		
		userResponseDTO.setMessage("Login Successfull");
		userResponseDTO.setUserId(userDB.getUserId());
		userResponseDTO.setStatusCode("200");		
		
		return userResponseDTO;
	}

	@Override
	public UserResponseDTO UserRegistrationM(User user) {
		
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		
		userRepo.save(user);
		userResponseDTO.setUserId(0);
		userResponseDTO.setMessage("User Saved Successfully");
		userResponseDTO.setStatusCode("200");
		
		
		return userResponseDTO;
	}
	
	
}
