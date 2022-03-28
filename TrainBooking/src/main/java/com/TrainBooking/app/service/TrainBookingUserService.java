package com.TrainBooking.app.service;

import org.springframework.http.ResponseEntity;

import com.TrainBooking.app.dto.UserRequestDTO;
import com.TrainBooking.app.dto.UserResponseDTO;
import com.TrainBooking.app.entity.User;

public interface TrainBookingUserService {

	ResponseEntity<UserResponseDTO> AthenticateUser(UserRequestDTO userRequestDTO);

	ResponseEntity<UserResponseDTO> UserRegistration(User user);

}
