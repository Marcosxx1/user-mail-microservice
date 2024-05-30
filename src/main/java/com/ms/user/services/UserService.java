package com.ms.user.services;

import com.ms.user.dtos.RegisterUserRequest;
import com.ms.user.entity.User;
import com.ms.user.exception.UserAlreadyRegisteredException;
import com.ms.user.mapper.UserMapper;
import com.ms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(RegisterUserRequest registerUserRequest) {
        var existUserWithEmail = userRepository.findByEmail(registerUserRequest.email());
        if (existUserWithEmail.isPresent()) {
            throw new RuntimeException("User already registered");
        }

        User user = UserMapper.mapRegistrationDtoToUser(registerUserRequest);

        return userRepository.save(user);

    }
}
