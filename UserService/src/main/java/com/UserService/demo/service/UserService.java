package com.UserService.demo.service;

import com.UserService.demo.dto.UserRequestDTO;
import com.UserService.demo.dto.UserResponseDTO;
import com.UserService.demo.entity.User;

public interface UserService {

	UserResponseDTO AuthenticateUser(UserRequestDTO userRequestDTO);

	UserResponseDTO UserRegistrationM(User user);

}
