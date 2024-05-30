package com.ms.user.mapper;

import com.ms.user.dtos.RegisterUserRequest;
import com.ms.user.entity.User;

public class UserMapper {


    public static User mapRegistrationDtoToUser(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setName(registerUserRequest.name());
        user.setEmail(registerUserRequest.email());
        user.setPassword(registerUserRequest.password());
        return user;
    }
}
