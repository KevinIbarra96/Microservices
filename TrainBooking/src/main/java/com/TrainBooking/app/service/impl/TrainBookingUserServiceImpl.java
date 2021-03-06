package com.TrainBooking.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TrainBooking.app.client.UserClient;
import com.TrainBooking.app.dto.UserRequestDTO;
import com.TrainBooking.app.dto.UserResponseDTO;
import com.TrainBooking.app.entity.User;
import com.TrainBooking.app.service.TrainBookingUserService;

@Service
public class TrainBookingUserServiceImpl implements TrainBookingUserService{
	
	@Autowired(required = false)
	UserClient userClient;

	@Override
	public ResponseEntity<UserResponseDTO> AthenticateUser(UserRequestDTO userRequestDTO) {
		
		return userClient.Login(userRequestDTO);
	}

	@Override
	public ResponseEntity<UserResponseDTO> UserRegistration(User user) {		
		return userClient.UserRegistration(user);
	}
	
}
