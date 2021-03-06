package com.TrainBooking.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.TrainBooking.app.dto.UserResponseDTO;
import com.TrainBooking.app.entity.User;
import com.TrainBooking.app.dto.UserRequestDTO;

@FeignClient(name = "USERSERVICE")
public interface UserClient {
	
	@PostMapping("/Login")	
	public ResponseEntity<UserResponseDTO> Login(@RequestBody UserRequestDTO userRequestDTO);
	
	@PostMapping("/Registry")
	public ResponseEntity<UserResponseDTO> UserRegistration(@RequestBody User user);
	
}
