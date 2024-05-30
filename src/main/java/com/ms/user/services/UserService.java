package com.ms.user.services;
import java.util.List;

import com.ms.user.dtos.RegisterUserRequest;
import com.ms.user.entity.User;
import com.ms.user.exception.UserAlreadyRegisteredException;
import com.ms.user.mapper.UserMapper;
import com.ms.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UUID save(RegisterUserRequest registerUserRequest) {
        var existUserWithEmail = userRepository.findByEmail(registerUserRequest.email());
        if (existUserWithEmail.isPresent()) {
            throw new RuntimeException("User already registered");
        }

        User user = UserMapper.mapRegistrationDtoToUser(registerUserRequest);

        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
