package com.UserService.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserService.demo.dto.UserRequestDTO;
import com.UserService.demo.dto.UserResponseDTO;
import com.UserService.demo.entity.User;
import com.UserService.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/Login")	
	public ResponseEntity<UserResponseDTO> Login(@RequestBody UserRequestDTO userRequestDTO) {
		UserResponseDTO userResponseDTO = userService.AuthenticateUser(userRequestDTO);
		
		return new ResponseEntity<UserResponseDTO>(userResponseDTO,HttpStatus.OK);
	}
	
	@PostMapping("/Registry")
	public ResponseEntity<UserResponseDTO> UserRegistration(@RequestBody User user){
		UserResponseDTO userResponseDTO = userService.UserRegistrationM(user);
		
		return new ResponseEntity<UserResponseDTO> (userResponseDTO,HttpStatus.OK); 
		
	}
	
	
	
	
}















